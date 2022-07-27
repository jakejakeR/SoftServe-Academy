package com.warriors.model;

import java.util.ArrayList;
import java.util.Collection;

public class Army {
    Collection<Unit> troops = new ArrayList<>();

    public void addUnits(Unit.Type unitType, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(unitType.getConstructor().get());
        }
    }

    public Collection<Unit> getTroops() {
        return troops;
    }
}
