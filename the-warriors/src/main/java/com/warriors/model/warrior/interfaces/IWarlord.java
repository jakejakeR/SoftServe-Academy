package com.warriors.model.warrior.interfaces;

import java.util.Collection;

@FunctionalInterface
public interface IWarlord {
    Collection<IWarrior> rearrangeTroops(Iterable<IWarrior> troopsToRearrange);
}
