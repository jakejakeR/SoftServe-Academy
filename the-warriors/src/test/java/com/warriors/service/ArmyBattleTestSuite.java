package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warriors.Healer;
import com.warriors.model.warriors.Knight;
import com.warriors.model.warriors.Lancer;
import com.warriors.model.warriors.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyBattleTestSuite {

    @Test
    void givenArmyOf1Warrior2KnightsAndAnotherArmyOf2Warriors1Knight_whenFightEachOther_ThenFirstArmyShouldWin() {

        // given
        var army1 = new Army();
        army1.addUnits(Warrior::new, 1).addUnits(Knight::new, 2);
        var army2 = new Army();
        army2.addUnits(Warrior::new, 2).addUnits(Knight::new, 1);

        // when
        var result = Battle.fight(army1, army2);
        var lastKnightAliveHealth = army1.firstAlive().next().getHealth();

        // then
        var expectedHealth = 22;
        assertTrue(result);
        assertEquals(expectedHealth, lastKnightAliveHealth);
    }

    @Test
    void givenArmyOf1LancerAndArmyOf1WarriorAndHealer_whenFightEachOther_thenTheSecondShouldWin() {

        // given
        Army army1 = new Army().addUnits(Lancer::new, 1);
        Army army2 = new Army().addUnits(Warrior::new, 1).addUnits(Healer::new, 1);

        // when
        var result = Battle.fight(army1, army2);
        var actualLancerHealth = army1.getTroops().get(0).getHealth();
        var actualWarriorHealth = army2.getTroops().get(0).getHealth();
        var actualHealerHealth = army2.getTroops().get(1).getHealth();

        // then
        assertFalse(result);
        assertEquals(0, actualLancerHealth);
        assertEquals(10, actualWarriorHealth);
        assertEquals(30, actualHealerHealth);
    }

    @Test
    void givenArmy1AndArmy2_whenStraightFightEachOther_thenTheFirstShouldWin() {

        //given
        var army1 = new Army()
                .addUnits(Warrior::new, 2)
                .addUnits(Knight::new, 1);
        var army2 = new Army()
                .addUnits(Knight::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Knight::new, 1);

        // when
        var result = Battle.straightFight(army1, army2);

        // then
        assertTrue(result);
    }

    @Test
    void givenArmy1AndArmy2_whenStraightFightEachOther_thenTheSecondShouldWin() {

        //given
        var army1 = new Army()
                .addUnits(Warrior::new, 10);
        var army2 = new Army()
                .addUnits(Warrior::new, 6)
                .addUnits(Lancer::new, 5);

        // when
        var result = Battle.straightFight(army1, army2);

        // then
        assertFalse(result);
    }
}