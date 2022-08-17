package com.warriors.model.warrior;

import com.warriors.model.equipment.Equipment;
import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.observer.Observer;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "OBSERVABLE LOG")
public class DeadWarrior extends Warrior {
    public static final int INITIAL_HEALTH = 1;
    public static final int INITIAL_ATTACK = 3;
    private int health;
    private final IWarrior decoratedWarrior;

    public DeadWarrior(IWarrior deadWarrior) {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        deadWarrior.dropEquipment();
        this.decoratedWarrior = deadWarrior;
        this.health = INITIAL_HEALTH;
    }

    @Override
    public Equipment getEquipment() {
        return decoratedWarrior.getEquipment();
    }

    @Override
    public int getAttack() {
        return INITIAL_ATTACK + getEquipment().getAttackModifiers();
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + getEquipment().getHealthModifiers();
    }

    @Override
    public void registerObserver(Observer observer) {
        decoratedWarrior.registerObserver(observer);
    }

    @Override
    public void notifyObserver(IWarrior warrior) {
        decoratedWarrior.notifyObserver(this);
    }
}
