package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.Knight;
import com.warriors.model.warrior.Lancer;
import com.warriors.model.warrior.Warrior;
import com.warriors.model.warrior.interfaces.Warlord;

/**
 * The Warriors app!
 */
public class TheWarriorsApp {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");
        var army = new Army();
        army.addUnits(Warrior::new, 2)
                .addUnits(Healer::new, 2)
                .addUnits(Warlord::new, 1)
                .addUnits(Knight::new, 1)
                .addUnits(Healer::new, 1)
                .addUnits(Lancer::new, 1);
        System.out.println(army);
        army.getTroops().get(0).reduceHealthBasedOnDamage(50);
        army.getTroops().get(2).reduceHealthBasedOnDamage(60);
        army.moveUnits();
        System.out.println(army);
        army.getTroops().get(0).reduceHealthBasedOnDamage(50);
        army.moveUnits();
        System.out.println(army);
    }
}
