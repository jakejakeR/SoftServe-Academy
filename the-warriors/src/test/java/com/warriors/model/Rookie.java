package com.warriors.model;

import com.warriors.model.warrior.Warrior;

/**
 * Class only for tests, especially for testing Defender
 */
class Rookie extends Warrior {
    @Override
    public int getAttack() {
        return 1;
    }
}
