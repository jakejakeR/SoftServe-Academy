package com.warriors.model;

import com.warriors.model.warrior.*;
import com.warriors.model.warrior.interfaces.IWarrior;

import java.util.function.Supplier;

public enum WarriorType {

    WARRIOR(Warrior::new),
    KNIGHT(Knight::new),
    DEFENDER(Defender::new),
    VAMPIRE(Vampire::new),
    LANCER(Lancer::new);

    private final Supplier<IWarrior> constructor;

    WarriorType(Supplier<IWarrior> constructor) {
        this.constructor = constructor;
    }

    Supplier<IWarrior> getConstructor() {
        return constructor;
    }
}
