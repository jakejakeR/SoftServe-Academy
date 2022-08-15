package com.warriors.model;

import com.warriors.model.warrior.*;
import org.junit.jupiter.api.Test;

class ArmyWithWarlord {

    @Test
    void testMoveUnits() {
        //Given
        System.out.println("Let the battle begin!");
        var army = new Army();
        army.addUnits(Warlord::new, 1)
                .addUnits(Warrior::new, 2)
                .addUnits(Healer::new, 2)
                .addUnits(Lancer::new, 10000000)
                .addUnits(Defender::new, 1);
        army.moveUnits();
        army.getWarriorFromTroops(2).reduceHealthBasedOnDamage(30);
        army.moveUnits();
    }
}
