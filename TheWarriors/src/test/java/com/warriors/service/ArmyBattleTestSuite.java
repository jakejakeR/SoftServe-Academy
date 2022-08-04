package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.WarriorType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmyBattleTestSuite {

    @Test
    void givenArmyOf1Warrior2KnightsAndAnotherArmyOf2Warriors1Knight_whenFightEachOther_ThenFirstArmyShouldWin() {
        // given
        var army1 = new Army();
        army1.addUnits(WarriorType.WARRIOR, 1).addUnits(WarriorType.KNIGHT, 2);
        var army2 = new Army();
        army2.addUnits(WarriorType.WARRIOR, 2).addUnits(WarriorType.KNIGHT, 1);

        // when
        var result = Battle.fight(army1, army2);
        var lastKnightAliveHealth = army1.firstAlive().next().getHealth();

        // then
        var expectedHealth = 22;
        assertTrue(result);
        assertEquals(expectedHealth, lastKnightAliveHealth);
    }
}