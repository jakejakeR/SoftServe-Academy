package com.warriors.service;

import com.warriors.model.warriors.Warrior;

class Rookie extends Warrior {
    @Override
    public int getAttack() {
        return 1;
    }
}
