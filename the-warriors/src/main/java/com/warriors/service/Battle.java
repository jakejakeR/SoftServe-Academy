package com.warriors.service;

import com.warriors.model.Army;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

/**
 * Battle simulation of fighting warriors
 */
@Slf4j(topic = "BATTLE LOG")
public class Battle {
    private static final String ATTACKING = "Attacking ";
    private static final String DEFENDING = "Defending ";

    private Battle() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean fight(IWarrior sideOne, IWarrior sideTwo) {
        LOGGER.info("* THE FIGHT HAS BEGUN *");
        LOGGER.info("* ATTACKER {}", sideOne);
        LOGGER.info("* DEFENDER {}", sideTwo);
        while (sideOne.isAlive() && sideTwo.isAlive()) {
            LOGGER.debug("{} HITS {}.", sideOne, sideTwo);
            sideOne.hit(sideTwo);
            if (sideTwo.isAlive()) {
                LOGGER.debug("{} HITS {}.", sideTwo, sideOne);
                sideTwo.hit(sideOne);
            }
        }
        LOGGER.info(
                "{} has won the fight!",
                sideOne.isAlive() ? ATTACKING + sideOne : DEFENDING + sideTwo
        );
        LOGGER.debug(
                "{} has lost...",
                !sideOne.isAlive() ? ATTACKING + sideOne : DEFENDING + sideTwo
        );
        return sideOne.isAlive();
    }

    public static boolean fight(Army attackingArmy, Army defendingArmy) {
        attackingArmy.lineUp().moveUnits();
        defendingArmy.lineUp().moveUnits();
        var iterator1 = attackingArmy.firstAlive();
        var iterator2 = defendingArmy.firstAlive();
        int roundCounter = 0;
        LOGGER.info("# THE BATTLE HAS BEGUN #");
        LOGGER.info("# ATTACKERS {}", attackingArmy);
        LOGGER.info("# DEFENDERS {}", defendingArmy);
        while (iterator1.hasNext() && iterator2.hasNext()) {
            LOGGER.info("ROUND #{}", ++roundCounter);
            fight(iterator1.next(), iterator2.next());
            attackingArmy.moveUnits();
            defendingArmy.moveUnits();
            LOGGER.debug("First army after fight: {}", attackingArmy);
            LOGGER.debug("Second army after fight: {}", defendingArmy);
        }
        LOGGER.info("THE BATTLE HAS ENDED IN ROUND #{}", roundCounter);
        LOGGER.info("WINNERS {}", iterator1.hasNext() ? attackingArmy : defendingArmy);
        LOGGER.info("LOSERS {}", !iterator1.hasNext() ? attackingArmy : defendingArmy);
        return iterator1.hasNext();
    }

    // Maybe I will try to use iterator instead?
    public static boolean straightFight(Army leftArmy, Army rightArmy) {
        LOGGER.info("The straight fight between {} and {} has begun!", leftArmy, rightArmy);
        leftArmy.deleteConnections();
        rightArmy.deleteConnections();
        while (leftArmy.isAlive() && rightArmy.isAlive()) {
            int smallerArmySize = Math.min(leftArmy.armySize(), rightArmy.armySize());

            for (int i = 0; i < smallerArmySize; i++) {
                fight(leftArmy.getWarriorFromTroops(i), rightArmy.getWarriorFromTroops(i));
            }

            leftArmy.removeDeadWarriors();
            rightArmy.removeDeadWarriors();
        }

        LOGGER.debug("First army after battle: {}", leftArmy);
        LOGGER.debug("Second army after battle: {}", rightArmy);
        return leftArmy.isAlive();
    }
}
