package com.warriors.model.warriors.interfaces;

import com.warriors.model.command.HealCommand;
import com.warriors.model.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;

public interface IWarrior extends CanAttack, HasHealth {
    default void hit(IWarrior opponent) {
        opponent.receiveDamage(new SimpleDamage(getAttack(), this));
        processCommand(new HealCommand(), this);
    }

    default void receiveDamage(IDamage damage) {
        reduceHealthBasedOnDamage(damage.getHitPoints());
    }

    /**
     *  Remove it do decorator in future
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
