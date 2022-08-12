package com.warriors.model;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.*;
import com.warriors.service.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponSuiteTest {

    @Test
    void suiteTest() {
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();

        var sword = Forge.forgeSword();
        var shield = Forge.forgeShield();
        var axe = Forge.forgeGreatAxe();
        var katana = Forge.forgeKatana();
        var wand = Forge.forgeMagicWand();
        // consider using a builder instead
        var superWeapon = Forge.forgeCustomWeapon()
                .name("Super weapon")
                .health(50)
                .attack(10)
                .defense(5)
                .vampirism(150)
                .healPower(8)
                .build();

        ogre.equipWeapon(sword);
        ogre.equipWeapon(shield);
        ogre.equipWeapon(superWeapon);
        lancelot.equipWeapon(superWeapon);
        richard.equipWeapon(shield);
        eric.equipWeapon(superWeapon);
        freelancer.equipWeapon(axe);
        freelancer.equipWeapon(katana);
        priest.equipWeapon(wand);
        priest.equipWeapon(shield);

        assertEquals(125, ogre.getHealth());
        assertEquals(17, lancelot.getAttack());
        assertEquals(4, richard.getDefense());
        assertEquals(200, eric.getVampirism());
        assertEquals(15, freelancer.getHealth());
        assertEquals(5, priest.getHealPower());

        assertFalse(Battle.fight(ogre, eric));
        assertFalse(Battle.fight(priest, richard));
        assertTrue(Battle.fight(lancelot, freelancer));
    }
}
