package com.warriors.model;

import com.warriors.model.warrior.Warrior;
import com.warriors.model.warrior.decorator.EquippedWarrior;
import com.warriors.model.weapon.Forge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GranularWeaponTest {

    @Test
    void givenWarrior_whenEquippedWithSword_thenHisAttackAndHealthShouldBeIncreased() {

        // given
        var warrior = new EquippedWarrior(new Warrior());
        var sword = Forge.forgeSword();

        // when
        warrior.equipWeapon(sword);

        // then
        int modifiedHealth = warrior.getHealth();
        int modifiedAttack = warrior.getAttack();
        int expectedModifiedHealth = 55;
        int expectedAttack = 7;

        //
        assertEquals(expectedModifiedHealth, modifiedHealth);
        assertEquals(expectedAttack, modifiedAttack);
    }
}
