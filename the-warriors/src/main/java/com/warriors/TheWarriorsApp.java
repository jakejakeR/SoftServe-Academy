package com.warriors;

import com.warriors.model.Army;
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
        army.addUnits(Warrior::new, 1).addUnits(Warlord::new, 1);
        army2.addUnits(Warrior::new, 2);
        Battle.fight(army, army2);
    }
}
