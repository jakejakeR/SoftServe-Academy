package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.Warrior;

/**
 * Battle simulation of fighting warriors
 */
public class Battle {

    private Battle() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean fight(Warrior warriorAttacker, Warrior warriorDefender) {
        while (warriorAttacker.isAlive() && warriorDefender.isAlive()) {
            warriorAttacker.hit(warriorDefender);
            if (warriorDefender.isAlive()) {
                warriorDefender.hit(warriorAttacker);
            }
        }
        return warriorAttacker.isAlive();
    }

    //TODO instead of casting, change Unit interface in order to allow taking Unit as parameter
    public static boolean fight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isAlive() && defendingArmy.isAlive()) {
            if (fight((Warrior) attackingArmy.getUnit(), (Warrior) defendingArmy.getUnit())) {
                defendingArmy.removeDeadUnit();
            } else {
                attackingArmy.removeDeadUnit();
            }
        }

        return attackingArmy.isAlive();
    }
}
