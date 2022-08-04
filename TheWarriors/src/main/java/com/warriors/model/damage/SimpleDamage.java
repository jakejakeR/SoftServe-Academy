package com.warriors.model.damage;

import com.warriors.model.warriors.interfaces.IWarrior;

public record SimpleDamage(int hitPoints, IWarrior damageDealer) implements IDamage {}
