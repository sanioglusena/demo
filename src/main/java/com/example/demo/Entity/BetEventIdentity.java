package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by senasanioglu on 4/19/18.
 */
@Embeddable
public class BetEventIdentity implements Serializable{

    @Column(name="bet_id")
    private int betId;

    @Column(name="rate_id")
    private int rate_id;

    public BetEventIdentity(int betId, int rate_id) {
        this.betId = betId;
        this.rate_id = rate_id;
    }

    public BetEventIdentity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BetEventIdentity that = (BetEventIdentity) o;

        if (betId != that.betId) return false;
        return (rate_id == that.rate_id);
    }

    @Override
    public int hashCode() {
        int result = Integer.toString(betId).hashCode();
        result = 31 * result + Integer.toString(rate_id).hashCode();
        return result;
    }

}
