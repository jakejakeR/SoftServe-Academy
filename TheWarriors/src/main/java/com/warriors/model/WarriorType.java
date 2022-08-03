package com.warriors.model;

import com.warriors.model.warriors.*;

import java.util.function.Supplier;

public enum WarriorType {

    WARRIOR(Warrior::new),
    KNIGHT(Knight::new),
    DEFENDER(Defender::new),
    VAMPIRE(Vampire::new),
    LANCER(Lancer::new);

    private final Supplier<Warrior> constructor;

    WarriorType(Supplier<Warrior> constructor) {
        this.constructor = constructor;
    }

    Supplier<Warrior> getConstructor() {
        return constructor;
    }
}
