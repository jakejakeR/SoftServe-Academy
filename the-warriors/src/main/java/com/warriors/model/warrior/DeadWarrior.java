package com.warriors.model.warrior;

import com.warriors.command.ICommand;
import com.warriors.model.equipment.Equipment;
import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.observer.Observer;

import java.util.Optional;

public class DeadWarrior implements IWarrior {
    public static final int INITIAL_HEALTH = 1;
    public static final int INITIAL_ATTACK = 3;
    private int health;
    private final IWarrior decoratedWarrior;

    public DeadWarrior(IWarrior deadWarrior) {
        deadWarrior.dropEquipment();
        this.decoratedWarrior = deadWarrior;
        this.health = INITIAL_HEALTH;
    }


    @Override
    public int getAttack() {
        return INITIAL_ATTACK;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH;
    }

    @Override
    public void setHealth(int health) {
        decoratedWarrior.setHealth(health);
    }

    @Override
    public Equipment getEquipment() {
        return decoratedWarrior.getEquipment();
    }

    @Override
    public Optional<IWarrior> getNextBehind() {
        return decoratedWarrior.getNextBehind();
    }

    @Override
    public void setNextBehind(IWarrior nextBehind) {
        decoratedWarrior.setNextBehind(nextBehind);
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        decoratedWarrior.processCommand(command, sender);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {HP:" + getHealth() + "| A:" + getAttack() + "}";
    }

    @Override
    public void registerObserver(Observer observer) {
        decoratedWarrior.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        decoratedWarrior.notifyObserver();
    }
}
