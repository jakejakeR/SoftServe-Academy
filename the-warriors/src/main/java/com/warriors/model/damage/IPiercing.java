package com.warriors.model.damage;

import com.warriors.model.warriors.interfaces.CanPierce;

public interface IPiercing extends CanPierce {

    void decreaseCounter();
    int getCounter();
}
