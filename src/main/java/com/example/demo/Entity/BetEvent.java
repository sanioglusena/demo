package com.example.demo.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table(name="bet_event")
public class BetEvent {

    @Id
    @Column(name="bet_id")
    private int betId;

    private int rate_id;

    public BetEvent(int betId, int rate_id) {
        this.betId = betId;
        this.rate_id = rate_id;
    }

    public BetEvent() {
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }
}
