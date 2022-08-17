package com.warriors.model;

import com.warriors.model.equipment.Forge;
import com.warriors.model.warrior.DeadWarrior;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.Lancer;
import com.warriors.model.warrior.Warrior;
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
        deadArmy.addUnits(() -> new DeadWarrior(new Healer()), 10).lineUp();
        var lancerArmy = new Army().addUnits(Lancer::new, 1).lineUp();

        // when
        lancerArmy.getWarriorFromTroops(0).hit(deadArmy.getWarriorFromTroops(0));

        // then
        assertEquals(-5, deadArmy.getWarriorFromTroops(0).getHealth());
        assertEquals(-2, deadArmy.getWarriorFromTroops(1).getHealth());
        assertEquals(1, deadArmy.getWarriorFromTroops(2).getHealth());
    }

    @Test
    void givenArmyOfDeadWarriorAndHealer_whenFightAgainstArmyOfOneWarrior_thenShouldNotAskForHeal() {

        // given
        var deadArmy = new Army();
        deadArmy.addUnits(() -> new DeadWarrior(new Lancer()), 1)
                .addUnits(Healer::new,1)
                .lineUp();
        var warriorArmy = new Army().addUnits(Warrior::new, 1).lineUp();

        // when
        deadArmy.getWarriorFromTroops(0).hit(warriorArmy.getWarriorFromTroops(0));

        // then
        assertEquals(1, deadArmy.getWarriorFromTroops(0).getHealth());
    }
}
