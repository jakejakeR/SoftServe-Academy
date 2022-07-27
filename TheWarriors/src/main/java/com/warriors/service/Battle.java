package com.warriors.service;

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
}
