package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.warrior.Knight;
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
            .addUnits(Warlord::new, 1)
            .addUnits(Knight::new, 1)
            .addUnits(Warlord::new, 5);
        System.out.println(army);
    }
}
