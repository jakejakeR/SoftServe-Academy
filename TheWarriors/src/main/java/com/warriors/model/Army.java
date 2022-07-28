package com.warriors.model;

import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private final Queue<Unit> troops = new LinkedList<>();

    public void addUnits(Unit.Type unitType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(unitType.getConstructor().get());
        }
    }

    public boolean isAlive() {
        return !troops.isEmpty();
    }

    public Unit getUnit() {
        return troops.peek();
    }

    public void killUnit() {
        troops.remove();
    }

    public Queue<Unit> getTroops() {
        return troops;
    }
}
