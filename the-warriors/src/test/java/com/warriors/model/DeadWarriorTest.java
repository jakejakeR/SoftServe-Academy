package com.warriors.model;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.DeadWarrior;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.Lancer;
import com.warriors.service.Battle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadWarriorTest {

    @Test
    void givenDeadHealerWithMagicWand_whenTurnedIntoDeadWarrior_thenDoesNotHaveHealerSpecifications() {

        // given
        var kaputHealer = new Healer();
        kaputHealer.equipWeapon(Forge.forgeMagicWand());
        kaputHealer.setHealth(0);

        // when
        var deadWarriorOfHealer = new DeadWarrior(kaputHealer);

        // then
        assertFalse(kaputHealer.isAlive());
        assertEquals(3, deadWarriorOfHealer.getAttack());
        assertEquals(1, deadWarriorOfHealer.getHealth());
        assertEquals(1, deadWarriorOfHealer.getInitialHealth());
        assertTrue(deadWarriorOfHealer.getEquipment().isEmpty());
    }

    @Test
    void givenArmyOfDeadWarriors_whenFightAgainstArmyOfOneLancer_thenDeadShouldPassPierceCommand() {
        // given
        var deadArmy = new Army();
        deadArmy.addUnits(() -> new DeadWarrior(new Healer()), 10);
        var lancerArmy = new Army().addUnits(Lancer::new, 1);

        // when
        Battle.fight(deadArmy, lancerArmy);
    }
}
