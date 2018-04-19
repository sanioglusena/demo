package com.example.demo.Entity;

import java.util.Date;

/**
 * Created by senasanioglu on 4/18/18.
 */
public class MyBet {

    private int userId;
    private Date timeStampofBet;
    private int amount;
    private int eventCount;
    private double rateSum;
    private int isShared;
    private int parentId;

    public MyBet() {
    }

    public MyBet(int userId, Date timeStampofBet, int amount, int eventCount, double rateSum) {
        this.userId = userId;
        this.timeStampofBet = timeStampofBet;
        this.amount = amount;
        this.eventCount = eventCount;
        this.rateSum = rateSum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getTimeStampofBet() {
        return timeStampofBet;
    }

    public void setTimeStampofBet(Date timeStampofBet) {
        this.timeStampofBet = timeStampofBet;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public double getRateSum() {
        return rateSum;
    }

    public void setRateSum(double rateSum) {
        this.rateSum = rateSum;
    }

    public int getIsShared() {
        return isShared;
    }

    public void setShared(int shared) {
        isShared = shared;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
