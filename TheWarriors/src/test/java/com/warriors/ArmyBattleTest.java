package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.WarriorType;
import com.warriors.model.warriors.Knight;
import com.warriors.service.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmyBattleTest {

    @Test
    void smokeTest() {
        var attackingArmy = new Army();
        var defendingArmy = new Army();
        var knightsArmy = new Army();
        var anotherArmy = new Army();

        defendingArmy.addUnits(WarriorType.WARRIOR, 3);
        knightsArmy.addUnits(Knight::new, 2).addUnits(Knight::new, 1);

        assertTrue(Battle.fight(attackingArmy, defendingArmy));
        assertFalse(Battle.fight(anotherArmy, knightsArmy));
    }
}