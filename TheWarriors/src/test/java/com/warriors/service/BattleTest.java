package com.warriors.service;

import com.warriors.model.warriors.Defender;
import com.warriors.model.warriors.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {

    //region Defender Granular tests
    @Test
    void givenRookie_whenHitsDefender_thenDefenderHealthDoNotIncrease() {
        // given
        var rookie = new Rookie();
        var defender = new Defender();
        var defenderInitialHealth = defender.getHealth();

        // when
        rookie.hit(defender);

        //then
        var expectedHealthAfterRookieHit = defender.getHealth();
        assertEquals(expectedHealthAfterRookieHit, defenderInitialHealth);
    }

    @Test
    void givenWarrior_whenHitsDefender_thenDefenderHealthShouldBeReducedByThree() {
        // given
        var warrior = new Warrior();
        var defender = new Defender();
        var defenderInitialHealth = defender.getHealth();

        // when
        warrior.hit(defender);

        // then
        int actualHealthDifference = defenderInitialHealth - defender.getHealth();
        int expectedHealthDifference = 3;
        assertEquals(expectedHealthDifference, actualHealthDifference);
    }
    //endregion
}

class Rookie extends Warrior {
    @Override
    public int getAttack() {
        return 1;
    }
}