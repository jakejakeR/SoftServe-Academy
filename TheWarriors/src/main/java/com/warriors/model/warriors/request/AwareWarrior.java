package com.warriors.model.warriors.request;

import com.warriors.model.warriors.interfaces.Fightable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AwareWarrior extends RequestHandler implements Fightable {
    private final Fightable decorated;
    private Fightable warriorBehind;
    private Fightable warriorAhead;

    public AwareWarrior(Fightable decorated, RequestHandler requestHandler) {
        super(requestHandler);
        this.decorated = decorated;
    }

    //region Boilerplate
    @Override
    public int getAttack() {
        return decorated.getAttack();
    }

    @Override
    public int getHealth() {
        return decorated.getHealth();
    }

    @Override
    public void setHealth(int health) {
        decorated.setHealth(health);
    }
    //endregion
}
