package com.warriors.model.warrior;

import com.warriors.command.ICommand;
import com.warriors.model.damage.IDamage;
import com.warriors.model.damage.IPiercing;
import com.warriors.model.equipment.Equipment;
import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.observer.Observer;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j(topic = "OBSERVABLE LOG")
public class Warrior implements IWarrior {
    private final List<Observer> observers;
    protected final Equipment equipment;
    public static final int INITIAL_ATTACK = 5;
    public static final int INITIAL_HEALTH = 50;
    private IWarrior nextBehindInArmy;
    private final int attack;
    private int health;

    public Warrior() {
        this(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
        this.equipment = new Equipment();
        this.observers = new ArrayList<>();
    }

    @Override
    public void processCommand(ICommand command, IWarrior sender) {
        if (!this.isAlive()) {
            return;
        }
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
            this.notifyObserver();
            return;
        }

        IWarrior.super.processCommand(command, sender);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        LOGGER.info("{} notifies observer", this);
        observers.forEach(observer -> observer.update(this));
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
    public Equipment getEquipment() {
        return equipment;
    }

    @Override
    public int getAttack() {
        return attack + equipment.getAttackModifiers();
    }

    @Override
    public int getHealth() {
        return health + equipment.getNonAppliedHealthModifiers();
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {HP:" + getHealth() + "| A:" + getAttack() + "}";
    }
}
