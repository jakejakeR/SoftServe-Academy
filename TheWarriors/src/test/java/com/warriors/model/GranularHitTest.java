package com.warriors.model;

import com.warriors.model.warriors.Defender;
import com.warriors.model.warriors.Vampire;
import com.warriors.model.warriors.Warrior;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GranularHitTest {

    //region Granular tests
    @Test
    void givenRookie_whenHitsDefender_thenDefenderHealthShouldNotIncrease() {
        LOGGER.info("Rookie hits Defender, Defender's health shouldn't increase.");

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
        LOGGER.info("Warrior hits Defender, Defender's health should be reduced by 3.");

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
    void givenVampireWith30Health_whenHitsWarrior_thenVampireHealthShouldIncreaseTo32() {
        LOGGER.info("Vampire with health: 30 hits Warrior, Vampire's health should increase to 32.");

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
    void givenVampireWith39Health_whenHitsWarrior_thenVampireHealthIncreasesTo40() {
        LOGGER.info("Vampire with health: 39 hits Warrior, Vampire's health should increase to 40.");

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
    void givenVampireWith37Health_whenHitsWarriorWith1Health_thenVampireHealthIncreasesTo39() {
        LOGGER.info("Vampire with health: 37 hits Warrior with health: 1, Vampire's health should increase to 39.");

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
        LOGGER.info("Vampire with health: 37 hits Defender, Vampire's health should increase to 38.");

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

