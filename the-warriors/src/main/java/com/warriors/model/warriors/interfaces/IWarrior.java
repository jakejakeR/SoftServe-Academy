package com.warriors.model.warriors.interfaces;

import com.warriors.model.command.HealCommand;
import com.warriors.model.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IWarrior extends CanAttack, HasHealth {
    default void hit(IWarrior opponent) {
        opponent.processCommand(new SimpleDamage(getAttack(), this), this);
        final Logger logger = LoggerFactory.getLogger("Hit logger");
        logger.info("{} hits {} (health after hit: {}).", this, opponent, opponent.getHealth());
        processCommand(new HealCommand(), this);
    }

    default void receiveDamage(IDamage damage) {
        reduceHealthBasedOnDamage(damage.getHitPoints());
    }

    /**
     * Remove it do decorator in future
     */
    default IWarrior getNextBehind() {
        return null;
    }

    default void setNextBehind(IWarrior nextBehind) {
        throw new UnsupportedOperationException();
    }

    default void processCommand(ICommand command, IWarrior sender) {
        var behind = getNextBehind();
        if (behind != null) {
            behind.processCommand(command, this);
        }
    }
}
