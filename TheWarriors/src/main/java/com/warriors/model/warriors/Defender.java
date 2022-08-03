package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Attackable;
import com.warriors.model.warriors.interfaces.Defendable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
        LOGGER.debug("{} blocks the attack from {} (attack: {}), and reduces damage to {}", this, damageDealer, damageDealer.getAttack(), damageDealer.getAttack() - getDefense());
        super.receiveHit(() ->
                Math.max(0, damageDealer.getAttack() - getDefense()));
    }

    @Override
    public int getDefense() {
        return defense;
    }
}
