package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Fightable;
import com.warriors.model.warriors.interfaces.Vampirism;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Vampire extends Warrior implements Vampirism {
    public static final int INITIAL_ATTACK = 4;
    public static final int INITIAL_HEALTH = 40;
    public static final int INITIAL_VAMPIRISM = 50;

    public Vampire() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public void hit(Fightable opponent) {
        int opponentsHealthBeforeHit = opponent.getHealth();

        super.hit(opponent);

        int opponentsHealthAfterHit = opponent.getHealth();
        int dealtDamage = opponentsHealthBeforeHit - opponentsHealthAfterHit;
        drainLife(dealtDamage);
        LOGGER.debug("{} drains life base on dealt damage ({}) from {} (Health left: {})", this, dealtDamage, opponent, opponent.getHealth());
    }

    @Override
    public int getVampirism() {
        return INITIAL_VAMPIRISM;
    }

    @Override
    public void drainLife(int dealtDamage) {
        int drainedLife = (dealtDamage * getVampirism()) / 100;
        this.setHealth(Math.min(INITIAL_HEALTH, (this.getHealth() + drainedLife)));
    }
}
