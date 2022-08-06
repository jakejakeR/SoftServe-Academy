package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warriors.interfaces.IWarrior;
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

    public static boolean fight(IWarrior sideOne, IWarrior sideTwo) {
        LOGGER.info("The fight between {} and {} has begun!", ATTACKING + sideOne, DEFENDING + sideTwo);
        while (sideOne.isAlive() && sideTwo.isAlive()) {
            sideOne.hit(sideTwo);
            LOGGER.debug("{} hits {} (health after hit: {}).", ATTACKING + sideOne, DEFENDING + sideTwo, sideTwo.getHealth());
            if (sideTwo.isAlive()) {
                sideTwo.hit(sideOne);
                LOGGER.debug("{} hits back {} (health after hit: {}).", DEFENDING + sideTwo, ATTACKING + sideOne, sideOne.getHealth());
            }
        }
        LOGGER.info(
                "{} has won the fight! (Health left: {}).",
                sideOne.isAlive() ? ATTACKING + sideOne : DEFENDING + sideTwo,
                sideOne.isAlive() ? sideOne.getHealth() : sideTwo.getHealth()
        );
        return sideOne.isAlive();
    }

    public static boolean fight(Army attackingArmy, Army defendingArmy) {
        var iterator1 = attackingArmy.firstAlive();
        var iterator2 = defendingArmy.firstAlive();
        LOGGER.info("The battle between {} and {} has begun!", attackingArmy, defendingArmy);
        while (iterator1.hasNext() && iterator2.hasNext()) {
            fight(iterator1.next(), iterator2.next());
        }
        LOGGER.info("{} has won the battle!}", iterator1.hasNext() ? attackingArmy : defendingArmy);
        return iterator1.hasNext();
    }

    // Maybe I will try to use iterator instead?
    public static boolean straightFight(Army leftArmy, Army rightArmy) {
        LOGGER.info("The straight fight between {} and {} has begun!", leftArmy, rightArmy);
        while (leftArmy.isAlive() && rightArmy.isAlive()) {
            int smallerArmySize = Math.min(leftArmy.getTroops().size(), rightArmy.getTroops().size());

            for (int i = 0; i < smallerArmySize; i++) {
                fight(leftArmy.getTroops().get(i), rightArmy.getTroops().get(i));
            }

            leftArmy.removeDeadWarriors();
            rightArmy.removeDeadWarriors();
        }
        return leftArmy.isAlive();
    }
}
