package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warrior.*;
import com.warriors.model.warrior.interfaces.Warlord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleWithWarlordSuiteTest {

    @Test
    void test1() {
        var ronald = new Warlord();
        var heimdall = new Knight();

        assertFalse(Battle.fight(heimdall, ronald));

        var myArmy = new Army();
        myArmy.addUnits(Warlord::new, 1);
        myArmy.addUnits(Warrior::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warlord::new, 3);
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);

        myArmy.moveUnits();
        enemyArmy.moveUnits();

// you can provide any other interface for testing the order
        assertEquals(Lancer.class, myArmy.unitAtPosition(0).getClass());
        assertEquals(Healer.class, myArmy.unitAtPosition(1).getClass());
// negative index means from the last position, so -1 == last
        assertEquals(Warlord.class, myArmy.unitAtPosition(myArmy.armySize() - 1).getClass());
        assertEquals(Vampire.class, enemyArmy.unitAtPosition(0).getClass());
        assertEquals(Warlord.class, enemyArmy.unitAtPosition(enemyArmy.armySize() - 1).getClass());
        assertEquals(Knight.class, enemyArmy.unitAtPosition(enemyArmy.armySize() - 2).getClass());

//6, not 8, because only 1 Warlord per army could be
        assertEquals(6, enemyArmy.armySize());

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }
}
