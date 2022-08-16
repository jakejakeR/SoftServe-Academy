package com.warriors.model.warrior;

import com.warriors.model.warrior.interfaces.IWarrior;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NightKing extends Warlord {

    @Override
    public Collection<IWarrior> rearrangeTroops(Iterable<IWarrior> troopsToRearrange) {
        List<IWarrior> rearrangedTroopsOfWarriors = new ArrayList<>(super.rearrangeTroops(troopsToRearrange));

        if ((rearrangedTroopsOfWarriors.get(0) == this) && rearrangedTroopsOfWarriors.size() > 1) {
            return raiseTheDead(rearrangedTroopsOfWarriors);
        } else {
            return rearrangedTroopsOfWarriors;
        }
    }

    private Collection<IWarrior> raiseTheDead(List<IWarrior> almostDeadTroops) {
        List<IWarrior> raisedFromDeathTroops;
//        for (IWarrior iWarrior : almostDeadTroops) {
//            if (!(iWarrior instanceof IWarlord)) {
//                iWarrior = new DeadWarrior(iWarrior);
//            }
//            raisedFromDeathTroops.add(iWarrior);
//        }

        raisedFromDeathTroops = almostDeadTroops.stream()
                .filter(warrior -> !warrior.isAlive())
                .map(DeadWarrior::new)
                .collect(Collectors.toList());

        raisedFromDeathTroops.add(this);
        return super.rearrangeTroops(raisedFromDeathTroops);
    }
}
