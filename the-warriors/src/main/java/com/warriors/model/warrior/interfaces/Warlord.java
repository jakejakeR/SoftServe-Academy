package com.warriors.model.warrior.interfaces;

import com.warriors.model.warrior.Defender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warlord extends Defender {
    public static final int INITIAL_HEALTH = 100;
    public static final int INITIAL_ATTACK = 4;

    public Warlord() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }
}
