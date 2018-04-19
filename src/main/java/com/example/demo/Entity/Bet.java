package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table(name="bet")
public class Bet {

    @Id
    @GeneratedValue
    @Column(name="bet_id")
    private int betId;

    @Column(name="user_id")
    private int userId;

    private Date timestamp;

    private int amount;

    private int is_shared;

    private int parent_bet;

    public Bet() {
    }

    public Bet(int userId, Date timestamp, int amount, int is_shared, int parent_bet) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.is_shared = is_shared;
        this.parent_bet = parent_bet;
    }

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int userId) {
        this.userId = userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIs_shared() {
        return is_shared;
    }

    public void setIs_shared(int is_shared) {
        this.is_shared = is_shared;
    }

    public int getParent_bet() {
        return parent_bet;
    }

    public void setParent_bet(int parent_bet) {
        this.parent_bet = parent_bet;
    }
}
