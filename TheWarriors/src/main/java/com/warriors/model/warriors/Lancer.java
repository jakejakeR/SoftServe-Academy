package com.warriors.model.warriors;

import com.warriors.model.damage.SimpleDamage;
import com.warriors.model.warriors.interfaces.CanPierce;
import com.warriors.model.warriors.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lancer extends Warrior implements CanPierce {
    public static final int INITIAL_ATTACK = 6;
    public static final int INITIAL_PIERCE_POWER = 50;
    private int attack;
    private int piercePower;

    public Lancer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        this.attack = INITIAL_ATTACK;
        this.piercePower = INITIAL_PIERCE_POWER;
    }

    @Override
    public void hit(IWarrior opponent) {
        int healthBeforeHit = opponent.getHealth();
        super.hit(opponent);
        int dealtDamage = healthBeforeHit - opponent.getHealth();

        LOGGER.info("{} hits {} and deals damage: {}.", this, opponent, dealtDamage);

        IWarrior nextBehind = opponent.getNextBehind();
        if (nextBehind != null) {
            int pierceDamage = dealtDamage * getPierce() / 100;
            int healthBeforePiercing = nextBehind.getHealth();
            nextBehind.receiveDamage(new SimpleDamage(pierceDamage, this));
            int piercingDamage = healthBeforePiercing - nextBehind.getHealth();

            LOGGER.info("{} stands behind {} and receives piercing damage: {}.", nextBehind, opponent, piercingDamage);
        }
    }

    @Override
    public int getPierce() {
        return piercePower;
    }
}
