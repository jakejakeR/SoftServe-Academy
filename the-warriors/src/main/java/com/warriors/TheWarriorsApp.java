package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.warrior.*;

/**
 * The Warriors app!
 */
public class TheWarriorsApp {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");
        var army = new Army();
        army.addUnits(NightKing::new, 1)
                .addUnits(Warrior::new, 2)
                .addUnits(Healer::new, 2)
                .addUnits(Lancer::new, 2)
                .addUnits(Defender::new, 1);
        System.out.println(army);
        army.moveUnits();

    }
}
