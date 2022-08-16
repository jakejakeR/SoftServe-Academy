package com.warriors.model.warrior;

import com.warriors.model.warrior.interfaces.IWarrior;
import com.warriors.model.warrior.interfaces.Vampirism;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "VAMPIRE LOG")
public class Vampire extends Warrior implements Vampirism {
    public static final int INITIAL_ATTACK = 4;
    public static final int INITIAL_HEALTH = 40;
    public static final int INITIAL_VAMPIRISM = 50;
    private final int vampirism;

    public Vampire() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        vampirism = INITIAL_VAMPIRISM;
    }

    @Override
    public void hit(IWarrior opponent) {
        int opponentsHealthBeforeHit = opponent.getHealth();

        super.hit(opponent);

        int opponentsHealthAfterHit = opponent.getHealth();
        int dealtDamage = opponentsHealthBeforeHit - opponentsHealthAfterHit;
        drainLife(dealtDamage);
        LOGGER.debug(
                "{} drains {} point(s) of life based on dealt damage ({}) from {}",
                this, dealtDamage / 2, dealtDamage, opponent
        );
    }

    @Override
    public int getVampirism() {
        return vampirism + equipment.getVampirismModifiers();
    }


    // move to setter
    public void drainLife(int dealtDamage) {
        int drainedLife = (dealtDamage * getVampirism()) / 100;
        this.setHealth(Math.min(getInitialHealth(), (this.getHealth() + drainedLife)));
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }
}
