package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.warrior.Healer;
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
        army.addUnits(Warlord::new, 1)
                .addUnits(Warrior::new, 2)
                .addUnits(Healer::new, 2)
                .addUnits(Lancer::new, 3);

        System.out.println(army);
        army.moveUnits();
        System.out.println(army);
        army.getWarriorFromTroops(2).reduceHealthBasedOnDamage(30);
        army.moveUnits();
        System.out.println(army);
    }
}
