package com.warriors.model;

import com.warriors.model.warriors.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/**
 * Warrior Factory, creates troops of Warriors
 */
@Slf4j
public class Army {
    private final List<IWarrior> troops = new ArrayList<>();

    public Iterator<IWarrior> firstAlive() {
        return new FirstAliveIterator();
    }

    public Army addUnits(Supplier<IWarrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            IWarrior warrior = factory.get();
            troops.add(warrior);
            LOGGER.debug("{} added to the army {}.", warrior, this);
        }
        return this;
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
     *  Delete connections between warriors in army if any
     *  in order to be sure that skills like pierce attack
     *  or heal are not executed in Battle.straightFight().
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
        int cursorNext = 1;

        /**
         * If the current warrior is not alive -> skip him (cursor++)
         * If the current warrior is alive -> exit loop
         * Iterator points to the first alive warrior
         *
         * @return true if next warrior is alive
         */
        @Override
        public boolean hasNext() {
            while (cursor < troops.size() && !troops.get(cursor).isAlive()) {
                cursor++;
                cursorNext = cursor + 1;
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
