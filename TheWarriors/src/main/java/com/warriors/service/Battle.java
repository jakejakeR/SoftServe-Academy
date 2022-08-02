package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warriors.interfaces.Fightable;
import lombok.extern.slf4j.Slf4j;

/**
 * Battle simulation of fighting warriors
 */
@Slf4j
public class Battle {
    private static final String ATTACKING = "attacking ";
    private static final String DEFENDING = "defending ";
    private Battle() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean fight(Fightable sideOne, Fightable sideTwo) {
        LOGGER.info("The fight between {} and {} has begun!", ATTACKING + sideOne, DEFENDING + sideTwo);
        while (sideOne.isAlive() && sideTwo.isAlive()) {
            sideOne.hit(sideTwo);
            LOGGER.debug("{} hits {} (health after hit: {}).", ATTACKING + sideOne, DEFENDING + sideTwo, sideTwo.getHealth());
            if (sideTwo.isAlive()) {
                sideTwo.hit(sideOne);
                LOGGER.debug("{} hits back {} (health after hit: {}).", DEFENDING + sideTwo, ATTACKING + sideOne, sideOne.getHealth());
            }
        }
        LOGGER.info("{} has won the fight! (Health left: {}).", sideOne.isAlive() ? ATTACKING + sideOne : DEFENDING + sideTwo, sideOne.isAlive() ?  sideOne.getHealth() : sideTwo.getHealth());
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

    public static boolean fightUsingIterator(Army attackingArmy, Army defendingArmy) {
        var iterator1 = attackingArmy.firstAlive();
        var iterator2 = defendingArmy.firstAlive();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            fight(iterator1.next(), iterator2.next());
        }

        return iterator1.hasNext();
    }
}
