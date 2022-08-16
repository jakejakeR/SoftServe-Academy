package com.warriors.model.warrior.interfaces.observer;

import com.warriors.model.warrior.interfaces.IWarrior;

@FunctionalInterface
public interface Observer {
    void update(IWarrior warrior);
}
