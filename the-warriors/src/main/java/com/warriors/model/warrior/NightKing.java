package com.warriors.model.warrior;

import com.warriors.model.warrior.interfaces.IWarlord;
import com.warriors.model.warrior.interfaces.IWarrior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NightKing extends Warlord {

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
        raisedFromDeathTroops = almostDeadTroops.stream()
                .filter(warrior -> !warrior.isAlive())
                .filter(warrior -> !(warrior instanceof DeadWarrior))
                .map(DeadWarrior::new)
                .collect(Collectors.toList());

        raisedFromDeathTroops.add(this);
        return super.rearrangeTroops(raisedFromDeathTroops);
    }
}
