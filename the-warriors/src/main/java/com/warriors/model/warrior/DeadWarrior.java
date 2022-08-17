package com.warriors.model.warrior;

import com.warriors.model.equipment.Equipment;
import com.warriors.model.warrior.interfaces.IWarrior;

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
}
