package com.warriors.model;

import com.warriors.model.warriors.Warrior;
import com.warriors.model.warriors.interfaces.Fightable;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

/**
 * Warrior Factory, creates troops of Warriors
 */
public class Army {
    private final Queue<Fightable> troops = new LinkedList<>();

    // Factory method pattern
    public Army addUnits(WarriorType warriorType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(warriorType.getConstructor().get());
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
