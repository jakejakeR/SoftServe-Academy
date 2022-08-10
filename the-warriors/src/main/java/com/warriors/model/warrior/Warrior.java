package com.warriors.model.warrior;

import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.IPiercing;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Warrior implements IWarrior {
    public static final int INITIAL_ATTACK = 5;
    public static final int INITIAL_HEALTH = 50;
    private IWarrior nextBehindInArmy;
    private int health;
    private int attack;

    public Warrior() {
        this(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        if (command instanceof IDamage damage) {
            int initialHealth = getHealth();
            receiveDamage(damage);
            int dealtDamage = initialHealth - getHealth();

            if (command instanceof IPiercing piercing && piercing.getCounter() > 1) {
                piercing.decreaseCounter();
                damage.setPierceHitPoints(dealtDamage);
                getNextBehind()
                        .ifPresent(iWarrior -> iWarrior.processCommand(command, this));
            }
            return;
        }

        IWarrior.super.processCommand(command, sender);
    }

    @Override
    public Optional<IWarrior> getNextBehind() {
        return Optional.ofNullable(nextBehindInArmy);
    }

    @Override
    public void setNextBehind(IWarrior nextBehind) {
        this.nextBehindInArmy = nextBehind;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getHealth() {
        LOGGER.trace("{} has {} points of health.", this, health);
        return health;
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.getHealth();
    }
}