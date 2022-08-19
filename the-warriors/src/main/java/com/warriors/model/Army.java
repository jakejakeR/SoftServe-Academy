package com.warriors.model;

import com.warriors.model.equipment.Weapon;
import com.warriors.model.warrior.Warlord;
import com.warriors.model.warrior.interfaces.HasHealth;
import com.warriors.model.warrior.interfaces.IWarlord;
import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.observer.Observer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Supplier;

/**
 * Warrior Factory, creates troops of Warriors
 */
@Slf4j(topic = "ARMY LOG")
public class Army implements Observer {
    private final List<IWarrior> troops = new ArrayList<>();
    private IWarlord warlord;

    public Iterator<IWarrior> firstAlive() {
        return new FirstAliveIterator();
    }

    /**
     * Adds Warriors to the collection of troops.
     * Prevents from adding more than 1 Warlords.
     * Sets Army as an Observer of each Warrior.
     * @param factory  supplier of warriors
     * @param quantity of warriors to add
     * @return fluent interface
     */
    public Army addUnits(Supplier<IWarrior> factory, int quantity) {
        if (factory.get() instanceof IWarlord warlordInstance) {
            if (troops.stream().noneMatch(Warlord.class::isInstance)) {
                warlord = warlordInstance;
                troops.add((IWarrior) warlord);
                LOGGER.info("Warlord added to the army!");
            } else {
                LOGGER.error("Warlord is already in army!");
            }
            return this;
        }

        for (int i = 0; i < quantity; i++) {
            IWarrior warrior = factory.get();
            troops.add(warrior);
            warrior.registerObserver(this);
            LOGGER.trace("{} added to the army {}.", warrior, this);
        }

        return this;
    }

    Logger observerLog = LoggerFactory.getLogger("OBSERVER LOG");

    @Override
    public void update(IWarrior warrior) {
        observerLog.debug("Observer has been notified by {}", warrior);
        if (!warrior.isAlive()) {
            observerLog.debug("Notifying {} is dead.", warrior);
            moveUnits();
        }
    }

    /**
     * Performs rearrange of units in Army
     * if there's a Warlord in troops collection.
     */
    public void moveUnits() {
        if (troops.stream().filter(HasHealth::isAlive).anyMatch(Warlord.class::isInstance)) {
            LOGGER.trace("There is a Warlord and he will move units!");
            LOGGER.debug("Army before moving units: {}", this);
            deleteConnections();
            Collection<IWarrior> rearrangedTroops = warlord.rearrangeTroops(troops);
            troops.clear();
            troops.addAll(rearrangedTroops);
            lineUp();
            LOGGER.debug("Army after moving units: {}", this);
        } else {
            LOGGER.trace("There is no Warlord or he's dead!");
        }
    }

    /**
     * Lines up warriors in army in order to
     * be sure that skills like pierce attack
     * or heal are executed in Battle.Fight().
     */
    public Army lineUp() {
        for (int i = 1; i < troops.size(); i++) {
            troops.get(i - 1).setNextBehind(troops.get(i));
        }
        return this;
    }

    /**
     * Delete connections between warriors in army if any
     * in order to be sure that skills like pierce attack
     * or heal are not executed in Battle.straightFight().
     */
    public Army deleteConnections() {
        for (IWarrior troop : troops) {
            troop.setNextBehind(null);
        }
        return this;
    }

    public int armySize() {
        return troops.size();
    }

    public IWarrior getWarriorFromTroops(int i) {
        return troops.get(i);
    }

    public boolean isAlive() {
        return !troops.isEmpty();
    }

    public void removeDeadWarriors() {
        troops.removeIf(iWarrior -> !iWarrior.isAlive());
    }

    public IWarrior unitAtPosition(int i) {
        return troops.get(i);
    }

    public void equipWarriorAtPosition(int i, Weapon weapon) {
        troops.get(i).equipWeapon(weapon);
    }

    @Override
    public String toString() {
        return "Army: " + troops;
    }

    /**
     * Iterator that always returns the first alive warrior,
     * not removes dead warriors, because maybe in future
     * they will be required to revive
     */
    private class FirstAliveIterator implements Iterator<IWarrior> {
        int cursor = 0;

        /**
         * If the current warrior is not alive -> skip him (cursor++)
         * If the current warrior is alive -> exit loop
         * Iterator points to the first alive warrior
         * @return true if next warrior is alive
         */
        @Override
        public boolean hasNext() {
            while (cursor < troops.size() && !troops.get(cursor).isAlive()) {
                cursor++;
            }
            return cursor < troops.size();
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return troops.get(cursor); // Typically, next() should return something and move to the next element
        }
    }
}
