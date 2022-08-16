package com.warriors.model.warrior.interfaces;

import com.warriors.command.HealCommand;
import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.SimpleDamage;
import com.warriors.model.equipment.Weapon;

import java.util.Optional;

public interface IWarrior extends CanAttack, HasHealth, HasEquipment {

    default void hit(IWarrior opponent) {
        opponent.processCommand(new SimpleDamage(getAttack(), this), this);
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

    @Override
    default HasEquipment equipWeapon(Weapon weapon) {
        HasEquipment.super.equipWeapon(weapon);
        this.setHealth(getHealth());
        weapon.setApplied(true);
        return this;
    }
}
