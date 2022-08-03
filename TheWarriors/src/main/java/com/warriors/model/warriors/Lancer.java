package com.warriors.model.warriors;

import com.warriors.model.warriors.interfaces.Fightable;
import com.warriors.model.warriors.interfaces.LongWeapon;
import com.warriors.model.warriors.request.Request;
import com.warriors.model.warriors.request.RequestType;

public class Lancer extends Warrior implements LongWeapon {
    public static final int INITIAL_ATTACK = 6;
    private int attack;

    public Lancer() {
        super(INITIAL_HEALTH, INITIAL_ATTACK);
        this.attack = INITIAL_ATTACK;
    }

    @Override
    public void hit(Fightable opponent) {
        Request lancerRequest = Request.create(RequestType.TAKE_HIT_FROM_LANCER);
//        AwareWarrior opponentWrapper = new AwareWarrior(opponent);
//        super.hit(opponentWrapper);
//
//        if (true) { //opponentWrapper.hasNextBehind) {
//            var requestSender = new RequestSender();
//            requestSender.buildChain(new RequestHandler(new RequestHandler(null)))
//                    .makeRequest(Request.create(RequestType.TAKE_HIT_FROM_LANCER));
//        }
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
