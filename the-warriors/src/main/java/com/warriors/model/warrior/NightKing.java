package com.warriors.model.warrior;

import com.warriors.model.warrior.interfaces.IWarlord;
import com.warriors.model.warrior.interfaces.IWarrior;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j(topic = "NIGHT KING LOG")
public class NightKing extends Warlord {

    /**
     * Performs rearrangement of troops just like super class does.
     * Additionally, if Night King is the only alive warrior in troops,
     * turns all dead Warriors into decorated new objects of
     * DeadWarriors.
     * @param troopsToRearrange Iterable of troops to rearrange.
     * @return Collection of rearranged warriors.
     */
    @Override
    public Collection<IWarrior> rearrangeTroops(Iterable<IWarrior> troopsToRearrange) {
        List<IWarrior> rearrangedTroopsOfWarriors = new ArrayList<>(super.rearrangeTroops(troopsToRearrange));

        boolean armyHasUndeadWarriorsExceptKing = rearrangedTroopsOfWarriors.stream()
                .filter(warrior -> !(warrior instanceof IWarlord))
                .allMatch(DeadWarrior.class::isInstance);

        if (rearrangedTroopsOfWarriors.get(0) == this && !armyHasUndeadWarriorsExceptKing) {
            return raiseTheDead(rearrangedTroopsOfWarriors);
        } else {
            return rearrangedTroopsOfWarriors;
        }
    }

    private Collection<IWarrior> raiseTheDead(List<IWarrior> almostDeadTroops) {
        List<IWarrior> raisedFromDeathTroops;
        LOGGER.info("{} raises all dead warriors!", this);
        LOGGER.debug("Army before raise: {}", almostDeadTroops);
        raisedFromDeathTroops = almostDeadTroops.stream()
                .filter(warrior -> !warrior.isAlive())
                .filter(warrior -> !(warrior instanceof DeadWarrior))
                .map(DeadWarrior::new)
                .collect(Collectors.toList());
        LOGGER.debug("The DeadArmy: {}", raisedFromDeathTroops);
        raisedFromDeathTroops.add(this);
        LOGGER.debug("The DeadArmy with NightKING: {}", raisedFromDeathTroops);
        return super.rearrangeTroops(raisedFromDeathTroops);
    }
}
