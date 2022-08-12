package com.warriors.service;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.Knight;
import com.warriors.model.warrior.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponFightSuiteTest {

    @Test
    void givenWarriorWithSword_whenFightsKnightWithKatana_thenWarriorShouldWin() {

        // given
        var warrior = new Warrior();
        var knight = new Knight();
        warrior.equipWeapon(Forge.forgeSword());
        knight.equipWeapon(Forge.forgeKatana());

        // when
        var result = Battle.fight(warrior, knight);

        // then
        assertTrue(result);
        assertEquals(3, warrior.getHealth());
        assertEquals(-5, knight.getHealth());
    }

    @Test
    void test1_givenWarriorWithCustomWeapon_whenFightsVampireWithSword_thenWarriorShouldWin() {

        // given
        var customWeapon = Forge.forgeCustomWeapon()
                .name("Baseball bat")
                .health(-10)
                .attack(5)
                .defense(0)
                .vampirism(40)
                .healPower(0)
                .build();

        var warrior = new Warrior();
        var vampire = new Warrior();
        warrior.equipWeapon(customWeapon);
        warrior.equipWeapon(Forge.forgeSword());

        // when
        var result = Battle.fight(warrior, vampire);

        // then
        assertTrue(result);
    }
}
