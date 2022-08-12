package com.warriors.model;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.Defender;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.Vampire;
import com.warriors.model.warrior.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GranularWeaponTest {

    @Test
    void givenWarrior_whenEquippedWithSword_thenHisAttackAndHealthShouldBeIncreased() {

        // given
        var warrior = new Warrior();
        var sword = Forge.forgeSword();

        // when
        warrior.equipWeapon(sword);

        // then
        int modifiedHealth = warrior.getHealth();
        int modifiedAttack = warrior.getAttack();
        int expectedModifiedHealth = 55;
        int expectedAttack = 7;

        assertEquals(expectedModifiedHealth, modifiedHealth);
        assertEquals(expectedAttack, modifiedAttack);
    }

    @Test
    void givenWoundedWarrior10Hp_whenEquippedWithSword_thenHisHpShouldIncreaseTo30() {

        // given
        var warrior = new Warrior();
        warrior.setHealth(10);

        // when
        var sword = Forge.forgeSword();
        warrior.equipWeapon(sword);

        // then
        assertEquals(15, warrior.getHealth());
    }

    @Test
    void givenWarrior_whenEquippedWithSwordAndKatana_thenHisAttackShouldBeIncreasedAndHealthDecreased() {

        // given
        var warrior = new Warrior();
        var sword = Forge.forgeSword();
        var katana = Forge.forgeKatana();

        // when
        warrior.equipWeapon(sword);
        warrior.equipWeapon(katana);

        // then
        int modifiedHealth = warrior.getHealth();
        int modifiedAttack = warrior.getAttack();
        int expectedModifiedHealth = 35;
        int expectedAttack = 13;

        assertEquals(expectedModifiedHealth, modifiedHealth);
        assertEquals(expectedAttack, modifiedAttack);
    }

    @Test
    void givenVampire_whenEquippedWithKatana_thenHisParametersShouldBeModified() {

        // given
        var vampire = new Vampire();
        var katana = Forge.forgeKatana();

        // when
        vampire.equipWeapon(katana);

        // then
        int modifiedHealth = vampire.getHealth();
        int modifiedAttack = vampire.getAttack();
        int modifiedVampirism = vampire.getVampirism();

        assertEquals(20, modifiedHealth);
        assertEquals(10, modifiedAttack);
        assertEquals(100, modifiedVampirism);
    }

    @Test
    void givenVampire_whenEquippedWith2Katanas_thenHeShouldBeDead() {

        // given
        var vampire = new Vampire();

        // when
        vampire.equipWeapon(Forge.forgeKatana());
        vampire.equipWeapon(Forge.forgeKatana());

        // then
        assertFalse(vampire.isAlive());
    }

    @Test
    void givenDefender_whenEquippedWithShield_thenHisParametersShouldBeModified() {

        // given
        var defender = new Defender();
        var shield = Forge.forgeShield();

        // when
        defender.equipWeapon(shield);

        // then
        assertEquals(80, defender.getHealth());
        assertEquals(2, defender.getAttack());
        assertEquals(4, defender.getDefense());
    }

    @Test
    void givenHealer_whenEquippedWithMagicWand_thenHisParametersShouldBeModified() {

        // given
        var healer = new Healer();
        var shield = Forge.forgeMagicWand();

        // when
        healer.equipWeapon(shield);

        // then
        assertEquals(90, healer.getHealth());
        assertEquals(0, healer.getAttack());
        assertEquals(5, healer.getHealPower());
    }
}
