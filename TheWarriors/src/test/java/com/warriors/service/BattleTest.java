package com.warriors.service;

import com.warriors.model.warriors.Defender;
import com.warriors.model.warriors.Vampire;
import com.warriors.model.warriors.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {

    //region Granular tests
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

    @Test
    void givenVampireWithHealth30_whenHitsWarrior_thenVampireHealthIncreasesTo32() {
        // given
        var vampire = new Vampire();
        vampire.setHealth(30);

        var warrior = new Warrior();

        // when
        vampire.hit(warrior);

        // then
        int expectedHealth = 32;
        int actualHealth = vampire.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void givenVampireWithHealth39_whenHitsWarrior_thenVampireHealthIncreasesTo40() {
        // given
        var vampire = new Vampire();
        vampire.setHealth(39);

        var warrior = new Warrior();

        // when
        vampire.hit(warrior);

        // then
        int expectedHealth = 40;
        int actualHealth = vampire.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void givenVampireWithHealth37_whenHitsWarriorWithHealth1_thenVampireHealthIncreasesTo39() {
        // given
        var vampire = new Vampire();
        vampire.setHealth(37);

        var warrior = new Warrior();
        warrior.setHealth(1);

        // when
        vampire.hit(warrior);

        // then
        int expectedHealth = 39;
        int actualHealth = vampire.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void givenVampireWithHealth37_whenHitsDefender_thenVampireHealthIncreasesTo38() {
        // given
        var vampire = new Vampire();
        vampire.setHealth(37);

        var defender = new Defender();

        // when
        vampire.hit(defender);

        // then
        int expectedHealth = 38;
        int actualHealth = vampire.getHealth();
        assertEquals(expectedHealth, actualHealth);
    }
    //endregion
}

