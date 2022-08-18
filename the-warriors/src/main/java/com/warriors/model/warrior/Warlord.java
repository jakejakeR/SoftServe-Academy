package com.warriors.model.warrior;

import com.warriors.model.warrior.interfaces.HasHealth;
import com.warriors.model.warrior.interfaces.IWarlord;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j(topic = "WARLORD LOG")
public class Warlord extends Defender implements IWarlord {
    public static final int INITIAL_HEALTH = 100;
    public static final int INITIAL_ATTACK = 4;

    public Warlord() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
    }

    @Override
    public int getInitialHealth() {
        return INITIAL_HEALTH + equipment.getHealthModifiers();
    }

    /**
     * Converts Iterable of troops to List of troops.
     * Divides List of troops into List of alive Warriors and List of dead Warriors.
     * Divides alive Warriors into separate Lists of particular types of Warriors.
     * Puts those Lists in proper order into base List of troops.
     * @param troopsToRearrange Iterable of troops to rearrange.
     * @return Collection of rearranged warriors.
     */
    @Override
    public Collection<IWarrior> rearrangeTroops(Iterable<IWarrior> troopsToRearrange) {
        List<IWarrior> rearrangedTroopsOfWarriors = new ArrayList<>();
        troopsToRearrange.forEach(rearrangedTroopsOfWarriors::add);
        rearrangedTroopsOfWarriors.remove(this);

        List<IWarrior> aliveWarriors = rearrangedTroopsOfWarriors.stream().filter(HasHealth::isAlive).toList();
        List<IWarrior> deadWarriors = rearrangedTroopsOfWarriors.stream().filter(warrior -> !(warrior.isAlive())).toList();

        List<IWarrior> healers = aliveWarriors.stream()
                .filter(Healer.class::isInstance)
                .toList();
        List<IWarrior> lancers = aliveWarriors.stream()
                .filter(Lancer.class::isInstance)
                .toList();
        List<IWarrior> rest = aliveWarriors.stream()
                .filter(warrior -> !(warrior instanceof Lancer) && !(warrior instanceof Healer))
                .toList();

        rearrangedTroopsOfWarriors.clear();

        if (!lancers.isEmpty()) {
            rearrangedTroopsOfWarriors.addAll(0, lancers);
            rearrangedTroopsOfWarriors.addAll(rest);
        } else {
            rearrangedTroopsOfWarriors.addAll(0, rest);
        }

        if (rest.isEmpty()) {
            rearrangedTroopsOfWarriors.addAll(0, healers);
        } else {
            rearrangedTroopsOfWarriors.addAll(1, healers);
        }

        rearrangedTroopsOfWarriors.add(this);
        rearrangedTroopsOfWarriors.addAll(deadWarriors);

        return rearrangedTroopsOfWarriors;
    }
}
