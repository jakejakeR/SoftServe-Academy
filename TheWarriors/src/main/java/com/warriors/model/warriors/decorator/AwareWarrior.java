package com.warriors.model.warriors.decorator;

import com.warriors.model.warriors.interfaces.Fightable;
import com.warriors.model.warriors.request.RequestHandler;

public class AwareWarrior extends RequestHandler implements Fightable {
    private final Fightable wrapped;
    private int health;

    public AwareWarrior(Fightable wrapped, RequestHandler handler) {
        super(handler);
        this.wrapped = wrapped;
        this.health = wrapped.getHealth();
    }

    //region Boilerplate
    @Override
    public int getAttack() {
        return wrapped.getAttack();
    }

    @Override
    public int getHealth() {
        return wrapped.getHealth();
    }

    @Override
    public void setHealth(int health) {
            this.health = health;
    }
    //endregion
}
