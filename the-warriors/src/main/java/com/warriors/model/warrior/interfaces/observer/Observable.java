package com.warriors.model.warrior.interfaces.observer;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObserver();
}
