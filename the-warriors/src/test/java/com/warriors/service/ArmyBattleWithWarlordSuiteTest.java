package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warrior.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleWithWarlordSuiteTest {

    @Test
    void warlordSuiteTest() {
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

    @Test
    @DisplayName("When Lancer kills Knight and Healer at the same time, the move Units command is called")
    void test123() {
        var armyOne = new Army();
        armyOne.addUnits(Warlord::new, 1);
        armyOne.addUnits(Knight::new, 1);
        armyOne.addUnits(Healer::new, 1);
        armyOne.addUnits(Warrior::new, 1);
        armyOne.getWarriorFromTroops(1).setHealth(6);
        armyOne.getWarriorFromTroops(2).setHealth(3);

        var armyTwo = new Army();
        armyTwo.addUnits(Lancer::new, 1);

        Battle.fight(armyTwo, armyOne);
    }

    @Test
    void theKnightKingTest() {
        var ronald = new NightKing();
        var heimdall = new Knight();

        assertFalse(Battle.fight(heimdall, ronald));

        var myArmy = new Army();
        myArmy.addUnits(NightKing::new, 1);
        myArmy.addUnits(Warrior::new, 2);
        myArmy.addUnits(Lancer::new, 2);
        myArmy.addUnits(Healer::new, 2);

        var enemyArmy = new Army();
        enemyArmy.addUnits(NightKing::new, 3);
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 2);
        enemyArmy.addUnits(Knight::new, 2);

        myArmy.moveUnits();
        enemyArmy.moveUnits();

// you can provide any other interface for testing the order
        assertEquals(Lancer.class, myArmy.unitAtPosition(0).getClass());
        assertEquals(Healer.class, myArmy.unitAtPosition(1).getClass());
// negative index means from the last position, so -1 == last
        assertEquals(NightKing.class, myArmy.unitAtPosition(myArmy.armySize() - 1).getClass());
        assertEquals(Vampire.class, enemyArmy.unitAtPosition(0).getClass());
        assertEquals(NightKing.class, enemyArmy.unitAtPosition(enemyArmy.armySize() - 1).getClass());
        assertEquals(Knight.class, enemyArmy.unitAtPosition(enemyArmy.armySize() - 2).getClass());

//6, not 8, because only 1 Warlord per army could be
        assertEquals(6, enemyArmy.armySize());

        assertTrue(Battle.fight(myArmy, enemyArmy));
    }
}
