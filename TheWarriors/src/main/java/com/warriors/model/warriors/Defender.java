package com.warriors.model.warriors;

import com.warriors.model.damage.IDamage;
import com.warriors.model.warriors.interfaces.HasDefense;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Defender extends Warrior implements HasDefense {
    private static final int INITIAL_HEALTH = 60;
    public static final int INITIAL_ATTACK = 3;
    private static final int INITIAL_DEFENSE = 2;
    private final int defense;

    public Defender() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        defense = INITIAL_DEFENSE;
    }

    @Override
    public void receiveDamage(IDamage damage) {
        int reducedDamage = damage.hitPoints() - getDefense();
        setHealth(getHealth() - Math.max(0, reducedDamage));

        LOGGER.debug(
                "{} blocks the attack from {} (attack: {}), and reduces damage to {}",
                this, damage.damageDealer(), damage.damageDealer().getAttack(), reducedDamage
        );
    }

    @Override
    public int getDefense() {
        return defense;
    }
}
