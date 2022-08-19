package com.warriors.model.warrior;

import com.warriors.command.damage.IDamage;
import com.warriors.model.warrior.interfaces.HasDefense;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DEFENSE LOG")
public class Defender extends Warrior implements HasDefense {
    public static final int INITIAL_HEALTH = 60;
    public static final int INITIAL_ATTACK = 3;
    public static final int INITIAL_DEFENSE = 2;
    private final int defense;

    public Defender() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        defense = INITIAL_DEFENSE;
    }

    protected Defender(int health, int attack) {
        super(health, attack);
        defense = INITIAL_DEFENSE;
    }

    @Override
    public void receiveDamage(IDamage damage) {
        int reducedDamage = damage.getHitPoints() - getDefense();
        LOGGER.debug(
                "{} blocks the attack from {} (damage: {}), and reduces damage to {}",
                this, damage.getDamageDealer(), damage.getHitPoints(), reducedDamage
        );

        setHealth(getHealth() - Math.max(0, reducedDamage));
    }

    @Override
    public int getDefense() {
        return defense + equipment.getDefenseModifiers();
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }
}
