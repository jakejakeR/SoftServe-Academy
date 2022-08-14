package com.warriors;

import com.warriors.model.Army;
import com.warriors.model.warrior.Knight;
import com.warriors.model.warrior.Warrior;
import com.warriors.model.warrior.interfaces.Warlord;
import com.warriors.service.Battle;

/**
 * The Warriors app!
 */
public class TheWarriorsApp {
    public static void main(String[] args) {
        System.out.println("Let the battle begin!");
        var army = new Army();
        var army2 = new Army();
        army.addUnits(Warlord::new, 1).addUnits(Warrior::new, 1);
        army2.addUnits(Knight::new, 5);
        Battle.fight(army, army2);
    }
}
