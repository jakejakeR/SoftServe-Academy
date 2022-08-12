package com.warriors.model.warrior.interfaces;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

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

    default Optional<IWarrior> getNextBehind() {
        return Optional.empty();
    }

    default void setNextBehind(IWarrior nextBehind) {
        throw new UnsupportedOperationException();
    }

    default void processCommand(ICommand command, IWarrior sender) {
        getNextBehind().ifPresent(iWarrior -> iWarrior.processCommand(command, this));
    }
}
