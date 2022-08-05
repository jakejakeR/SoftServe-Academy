package com.warriors.model;

import com.warriors.model.warriors.interfaces.IWarrior;
import com.warriors.model.warriors.request.RequestSender;
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
public class Army extends RequestSender {
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

    public Army lineUp() {
        for (int i = 1; i < troops.size(); i++) {
            troops.get(i - 1).setNextBehind(troops.get(i));
        }
        return this;
    }

    @Override
    public String toString() {
        return "Army: " + troops;
    }

    public List<IWarrior> getTroops() {
        return troops;
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
