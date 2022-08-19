package com.warriors.model.warrior.interfaces;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.command.damage.IDamage;
import com.warriors.command.damage.SimpleDamage;
import com.warriors.model.equipment.Weapon;
import com.warriors.model.warrior.DeadWarrior;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.interfaces.observer.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public interface IWarrior extends CanAttack, HasHealth, HasEquipment, Observable {

    Logger hitLog = LoggerFactory.getLogger("HIT LOG");
    Logger healRequestLog = LoggerFactory.getLogger("REQUEST HEAL LOG");

    /**
     * Sends a Damage command do opponent.
     * If sender has a Healer behind him and is not a type od DeadWarrior
     * then sends heal request to the healer behind.
     * @param opponent that receives a command to process.
     */
    default void hit(IWarrior opponent) {
        hitLog.debug("{} HITS {}.", this, opponent);
        opponent.processCommand(new SimpleDamage(getAttack(), this), this);

        if (this.getNextBehind().orElse(null) instanceof Healer healer && !(this instanceof DeadWarrior)) {
            healRequestLog.debug("{} sends heal request to {}.", this, healer);
            processCommand(new HealCommand(), this);
        }
    }

    default void receiveDamage(IDamage damage) {
        reduceHealthBasedOnDamage(damage.getHitPoints());
    }

    default void processCommand(ICommand command, IWarrior sender) {
        getNextBehind().ifPresent(iWarrior -> iWarrior.processCommand(command, this));
    }

    default Optional<IWarrior> getNextBehind() {
        return Optional.empty();
    }

    default void setNextBehind(IWarrior nextBehind) {
        throw new UnsupportedOperationException();
    }

    @Override
    default HasEquipment equipWeapon(Weapon weapon) {
        HasEquipment.super.equipWeapon(weapon);
        this.setHealth(getHealth());
        weapon.setApplied(true);
        return this;
    }
}
