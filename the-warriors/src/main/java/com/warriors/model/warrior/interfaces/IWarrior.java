package com.warriors.model.warrior.interfaces;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public abstract class IWarrior implements CanAttack, HasHealth {
    public void hit(IWarrior opponent) {
        opponent.processCommand(new SimpleDamage(getAttack(), this), this);
        final Logger logger = LoggerFactory.getLogger("Hit logger");
        logger.info("{} hits {} (health after hit: {}).", this, opponent, opponent.getHealth());
        processCommand(new HealCommand(), this);
    }

    public void receiveDamage(IDamage damage) {
        reduceHealthBasedOnDamage(damage.getHitPoints());
    }

    public void reduceHealthBasedOnDamage(int hitPoints) {
        setHealth(getHealth() - hitPoints);
    }

    public Optional<IWarrior> getNextBehind() {
        return Optional.empty();
    }

    public void setNextBehind(IWarrior nextBehind) {
        throw new UnsupportedOperationException();
    }

    public abstract void processCommand(ICommand command, IWarrior sender);

    public abstract void setHealth(int health);

    public abstract int getInitialHealth();
}
