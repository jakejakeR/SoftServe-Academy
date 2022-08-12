package com.warriors.model;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GranularWeaponTest {

    @Test
    void givenWarrior_whenEquippedWithSword_thenHisAttackAndHealthShouldBeIncreased() {

        // given
        var warrior = new Warrior();
        var sword = Forge.forgeSword();

        // when
        //warrior.equipWeapon(sword);

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
