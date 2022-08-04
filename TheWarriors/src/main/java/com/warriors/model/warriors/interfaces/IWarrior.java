package com.warriors.model.warriors.interfaces;

import com.warriors.model.damage.IDamage;

public interface IWarrior extends CanAttack, HasHealth {
    void hit(IWarrior opponent);

    void receiveDamage(IDamage damage);
}
