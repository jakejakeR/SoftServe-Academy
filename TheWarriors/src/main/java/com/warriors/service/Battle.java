package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warriors.interfaces.Fightable;

/**
 * Battle simulation of fighting warriors
 */
public class Battle {

    private Battle() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean fight(Fightable sideOne, Fightable sideTwo) {
        while (sideOne.isAlive() && sideTwo.isAlive()) {
            sideOne.hit(sideTwo);
            if (sideTwo.isAlive()) {
                sideTwo.hit(sideOne);
            }
        }
        return sideOne.isAlive();
    }

    public static boolean fight(Army attackingArmy, Army defendingArmy) {
        while (attackingArmy.isAlive() && defendingArmy.isAlive()) {
            if (fight(attackingArmy.getUnit(), defendingArmy.getUnit())) {
                defendingArmy.removeDeadUnit();
            } else {
                attackingArmy.removeDeadUnit();
            }
        }
        return attackingArmy.isAlive();
    }
}
