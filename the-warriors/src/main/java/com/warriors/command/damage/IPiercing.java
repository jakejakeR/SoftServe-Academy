package com.warriors.command.damage;

import com.warriors.model.warrior.interfaces.CanPierce;

public interface IPiercing extends CanPierce {

    void decreaseCounter();
    int getCounter();
}
