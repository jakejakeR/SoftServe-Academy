package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Attackable;
import com.warriors.model.warriors.interfaces.Defendable;

public class Defender extends Warrior implements Defendable {
    private static final int INITIAL_HEALTH = 60;
    private static final int INITIAL_DEFENSE = 2;
    private final int defense;

    public Defender() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        defense = INITIAL_DEFENSE;
    }

    @Override
    public void receiveHit(Attackable damageDealer) {
        super.receiveHit(() ->
                Math.max(0, damageDealer.getAttack() - getDefense()));
    }

    @Override
    public int getDefense() {
        return defense;
    }
}
