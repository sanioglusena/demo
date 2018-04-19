package com.example.demo.Entity;

import java.util.Date;

/**
 * Created by senasanioglu on 4/18/18.
 */
public class EventDetail {

    private int eventId;
    private Date timeStampofBet;
    private String team1;
    private String team2;
    private double rate;
    private int resultType;

    public EventDetail() {
    }

    public EventDetail(int eventId, Date timeStampofBet, String team1, String team2, double rate, int resultType) {
        this.eventId = eventId;
        this.timeStampofBet = timeStampofBet;
        this.team1 = team1;
        this.team2 = team2;
        this.rate = rate;
        this.resultType = resultType;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Date getTimeStampofBet() {
        return timeStampofBet;
    }

    public void setTimeStampofBet(Date timeStampofBet) {
        this.timeStampofBet = timeStampofBet;
    }

    public int getResultType() {
        return resultType;
    }

    public void setResultType(int resultType) {
        this.resultType = resultType;
    }
}
