package com.example.demo.Entity;


import javax.persistence.*;


/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table(name="bet_event")
public class BetEvent {

    @EmbeddedId
    private BetEventIdentity betEventIdentity;

    public BetEvent() {
    }

    public BetEvent(BetEventIdentity betEventIdentity) {
        this.betEventIdentity = betEventIdentity;
    }

    public BetEventIdentity getBetEventIdentity() {
        return betEventIdentity;
    }

    public void setBetEventIdentity(BetEventIdentity betEventIdentity) {
        this.betEventIdentity = betEventIdentity;
    }
}
