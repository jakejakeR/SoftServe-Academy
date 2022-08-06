package com.warriors.model;

import com.warriors.model.warriors.*;
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
    void givenDefender_whenHitsWarrior_thenWarriorsHealthShouldDecreaseBy3() {
        LOGGER.info("Defender hits Warrior, Warrior's health should be reduced by 3.");

        // given
        var defender = new Defender();
        var warrior = new Warrior();
        var warriorInitialHealth = warrior.getHealth();

        // when
        defender.hit(warrior);


        // then
        var actualDifference = warriorInitialHealth - warrior.getHealth();
        var expectedDifference = 3;
        assertEquals(expectedDifference, actualDifference);
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

    @Test
    void givenLancerInArmy1_whenHitsWarriorInArmy2_thenWarriorsHealthShouldDecreaseBy6AndWarriorsHealthBehindHimBy3() {

        // given
        var army1 = new Army();
        army1.addUnits(Lancer::new, 1).lineUp();
        var army2 = new Army();
        army2.addUnits(Warrior::new, 2).lineUp();

        var lancer = army1.getTroops().get(0);
        var warrior = army2.getTroops().get(0);
        var warriorBehind = army2.getTroops().get(1);

        var warriorInitialHealth = warrior.getHealth();
        var warriorBehindInitialHealth = warriorBehind.getHealth();

        // when
        lancer.hit(warrior);

        // then
        var expectedWarriorDamage = 6;
        var expectedWarriorBehindDamage = 3;

        var actualWarriorDamage = warriorInitialHealth - warrior.getHealth();
        var actualWarriorBehindDamage = warriorBehindInitialHealth - warriorBehind.getHealth();
        assertEquals(expectedWarriorDamage, actualWarriorDamage);
        assertEquals(expectedWarriorBehindDamage, actualWarriorBehindDamage);
    }

    @Test
    void givenLancerInArmy1_whenHitsWarriorInArmy2_thenWarriorsHealthShouldDecreaseBy6AndDefendersHealthBehindHimBy1() {

        // given
        var army1 = new Army();
        army1.addUnits(Lancer::new, 1).lineUp();
        var army2 = new Army();
        army2.addUnits(Warrior::new, 1).addUnits(Defender::new, 1).lineUp();

        var lancer = army1.getTroops().get(0);
        var warrior = army2.getTroops().get(0);
        var defenderBehind = army2.getTroops().get(1);

        var warriorInitialHealth = warrior.getHealth();
        var defenderBehindInitialHealth = defenderBehind.getHealth();

        // when
        lancer.hit(warrior);

        // then
        var expectedWarriorDamage = 6;
        var expectedDefenderBehindDamage = 1;

        var actualWarriorDamage = warriorInitialHealth - warrior.getHealth();
        var actualDefenderBehindDamage = defenderBehindInitialHealth - defenderBehind.getHealth();
        assertEquals(expectedWarriorDamage, actualWarriorDamage);
        assertEquals(expectedDefenderBehindDamage, actualDefenderBehindDamage);
    }

    @Test
    void givenLancerInArmy1_whenHitsDefenderInArmy2_thenDefendersHealthShouldDecreaseBy4AndWarriorsHealthBehindHimBy2() {

        // given
        var army1 = new Army();
        army1.addUnits(Lancer::new, 1).lineUp();
        var army2 = new Army();
        army2.addUnits(Defender::new, 1).addUnits(Warrior::new, 1).lineUp();

        var lancer = army1.getTroops().get(0);
        var defender = army2.getTroops().get(0);
        var warriorBehind = army2.getTroops().get(1);

        var defenderInitialHealth = defender.getHealth();
        var warriorBehindInitialHealth = warriorBehind.getHealth();

        // when
        lancer.hit(defender);

        // then
        var expectedDefenderDamage = 4;
        var expectedWarriorBehindDamage = 2;

        var actualDefenderDamage = defenderInitialHealth - defender.getHealth();
        var actualWarriorBehindDamage = warriorBehindInitialHealth - warriorBehind.getHealth();
        assertEquals(expectedDefenderDamage, actualDefenderDamage);
        assertEquals(expectedWarriorBehindDamage, actualWarriorBehindDamage);
    }

    @Test
    void givenLancerInArmy1_whenHitsDefenderInArmy2_thenDefendersHealthShouldDecreaseBy4AndDefendersHealthBehindHimShouldNotDecrease() {

        // given
        var army1 = new Army();
        army1.addUnits(Lancer::new, 1).lineUp();
        var army2 = new Army();
        army2.addUnits(Defender::new, 2).lineUp();

        var lancer = army1.getTroops().get(0);
        var defender = army2.getTroops().get(0);
        var defenderBehind = army2.getTroops().get(1);

        var defenderInitialHealth = defender.getHealth();
        var defenderBehindInitialHealth = defenderBehind.getHealth();

        // when
        lancer.hit(defender);

        // then
        var expectedDefenderDamage = 4;
        var expectedDefenderBehindDamage = 0;

        var actualDefenderDamage = defenderInitialHealth - defender.getHealth();
        var actualDefenderBehindDamage = defenderBehindInitialHealth - defenderBehind.getHealth();
        assertEquals(expectedDefenderDamage, actualDefenderDamage);
        assertEquals(expectedDefenderBehindDamage, actualDefenderBehindDamage);
    }

    @Test
    void givenHealerInDefendingArmyStandsBehindWarrior_whenInjuredWarriorHitsBackLancer_thenHealerHealsHimBy2() {

        // given
        var attackingArmy = new Army();
        attackingArmy.addUnits(Lancer::new, 1).lineUp();
        var defendingArmy = new Army();
        defendingArmy.addUnits(Warrior::new, 1).addUnits(Healer::new, 1).lineUp();
        var lancer = attackingArmy.getTroops().get(0);
        var warrior = defendingArmy.getTroops().get(0);
        var healer = defendingArmy.getTroops().get(1);

        // when
        lancer.hit(warrior);
        var injuredWarriorHealth = warrior.getHealth();
        var expectedHealthAfterHit = 44;

        warrior.hit(lancer);
        var healthAfterHealing = warrior.getHealth();
        var expectedHealthAfterHealing = 46;
        var healthHealed = healthAfterHealing - injuredWarriorHealth;
        var expectedHealthHealed = 2;

        // then
        assertEquals(expectedHealthAfterHit, injuredWarriorHealth);
        assertEquals(expectedHealthAfterHealing, healthAfterHealing);
        assertEquals(expectedHealthHealed, healthHealed);
    }

    @Test
    void givenHealer_whenHealsWarriorWith49Health_thenWarriorShouldBeHealedTo50() {

        // given
        var warrior = new Warrior();
        var expectedHealthBeforeHeal = 49;
        warrior.setHealth(expectedHealthBeforeHeal);
        var healer = new Healer();

        // when
        var warriorHealthBeforeHeal = warrior.getHealth();
        healer.heal(warrior);
        var warriorHealthAfterHeal = warrior.getHealth();
        var expectedHealthAfterHeal = 50;

        // then
        assertEquals(expectedHealthBeforeHeal, warriorHealthBeforeHeal);
        assertEquals(expectedHealthAfterHeal, warriorHealthAfterHeal);
    }
    //endregion
}


