package com.warriors.model.warrior.interfaces;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import com.warriors.model.equipment.Weapon;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.interfaces.observer.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public interface IWarrior extends CanAttack, HasHealth, HasEquipment, Observable {

    Logger LOGGER = LoggerFactory.getLogger("HIT LOG");
    default void hit(IWarrior opponent) {
        LOGGER.debug("{} HITS {}.", this, opponent);
        opponent.processCommand(new SimpleDamage(getAttack(), this), this);
        if (this.getNextBehind().orElse(null) instanceof Healer) {
            processCommand(new HealCommand(), this);
        }
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

    @Override
    default HasEquipment equipWeapon(Weapon weapon) {
        HasEquipment.super.equipWeapon(weapon);
        this.setHealth(getHealth());
        weapon.setApplied(true);
        return this;
    }
}
