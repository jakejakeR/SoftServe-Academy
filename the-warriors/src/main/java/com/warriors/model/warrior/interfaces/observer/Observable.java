package com.warriors.model.warrior.interfaces.observer;

import com.warriors.model.warrior.interfaces.IWarrior;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObserver(IWarrior warrior);
}
