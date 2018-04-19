package com.example.demo.Entity;

import javax.persistence.*;

/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table(name="event_rates")
public class EventRate {

    @Id
    @GeneratedValue
    @Column(name="rateId")
    private int rateId;

    private int event_id;

    private int result_type;

    private int rate;

    public EventRate(int event_id, int result_type, int rate) {
        this.event_id = event_id;
        this.result_type = result_type;
        this.rate = rate;
    }

    public EventRate() {
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getResult_type() {
        return result_type;
    }

    public void setResult_type(int result_type) {
        this.result_type = result_type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
