package com.warriors.model.warrior.interfaces;

import com.warriors.model.warrior.Defender;
import com.warriors.model.warrior.Healer;
import com.warriors.model.warrior.Lancer;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class Warlord extends Defender implements Comparator<IWarrior> {
    public static final int INITIAL_HEALTH = 100;
    public static final int INITIAL_ATTACK = 4;

    public Warlord() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }

    @Override
    public int compare(IWarrior o1, IWarrior o2) {
        if (!o1.isAlive()) {
            return 1;
        }
        if (!o2.isAlive()) {
            return -1;
        }
        if (o1 instanceof Healer && o1.isAlive()) {
            return -1;
        }
        if (o2 instanceof Healer && o1.isAlive()) {
            return 1;
        }
        if (o1 instanceof Lancer) {
            return -1;
        }
        if (o1 instanceof Warlord && o1.isAlive()) {
            return 1;
        }
        if (o2 instanceof Warlord && o1.isAlive()) {
            return -1;
        }
        return 0;
    }
}
