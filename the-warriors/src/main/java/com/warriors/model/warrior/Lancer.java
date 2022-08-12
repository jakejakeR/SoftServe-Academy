package com.warriors.model.warrior;

import com.warriors.command.HealCommand;
import com.warriors.model.damage.PiercingDamage;
import com.warriors.model.warrior.interfaces.CanPierce;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lancer extends Warrior implements CanPierce {
    public static final int INITIAL_ATTACK = 6;
    public static final int INITIAL_PIERCE_POWER = 50;
    private int attack;
    private int piercePower;

    public Lancer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        this.attack = INITIAL_ATTACK;
        this.piercePower = INITIAL_PIERCE_POWER;
    }

    @Override
    public void hit(IWarrior opponent) {
        opponent.processCommand(new PiercingDamage(getAttack(), this, getPierce()), this);
        LOGGER.info("{} hits {} (health after hit: {}).", this, opponent, opponent.getHealth());
        processCommand(new HealCommand(), this);
    }

    @Override
    public int getPierce() {
        return piercePower;
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }
}
