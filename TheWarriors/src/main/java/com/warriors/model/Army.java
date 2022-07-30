package com.warriors.model;

import com.warriors.model.warriors.Warrior;
import com.warriors.model.warriors.interfaces.Fightable;

import java.util.*;
import java.util.function.Supplier;

/**
 * Warrior Factory, creates troops of Warriors
 */
public class Army {
    private final Queue<Fightable> troops = new LinkedList<>();

    /* Iterator that always returns the first alive warrior,
    not removes dead warriors, because maybe in future
    they will be required to revive */
    private final List<Fightable> troopsList = new ArrayList<>();

    public Iterator<Fightable> firstAlive() {
        return new FirstAliveIterator();
    }

    private class FirstAliveIterator implements Iterator<Fightable> {
        int cursor = 0;

        /**
         * If the current warrior is not alive -> skip him (cursor++)
         * If the current warrior is alive -> exit loop
         * Iterator points to the first alive warrior
         *
         * @return true if next warrior is alive
         */
        @Override
        public boolean hasNext() {
            while (cursor < troopsList.size() && !troopsList.get(cursor).isAlive()) {
                cursor++;
            }
            return cursor < troopsList.size();
        }

        @Override
        public Fightable next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return troopsList.get(cursor); // Typically, next() should return something and move to the next element
        }
    }


    // Factory method pattern (adding warriors to troopsCollection!!!)
    public Army addUnits(WarriorType warriorType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troopsList.add(warriorType.getConstructor().get());
        }
        return this;
    }

    // Prototype pattern
    public Army addUnits(Warrior prototype, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(prototype.clone());
        }
        return this;
    }

    // Using supplier
    public Army addUnits(Supplier<Fightable> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }

    public boolean isAlive() {
        return !troops.isEmpty();
    }

    public Fightable getUnit() {
        return troops.peek();
    }

    public void removeDeadUnit() {
        troops.remove();
    }
}
