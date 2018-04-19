package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table(name="event")
public class Event {

    @Id
    @GeneratedValue
    private int event_id;
    private Date time;
    private int home_team;
    private int away_team;

    public Event(Date time, int home_team, int away_team) {
        this.time = time;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public Event() {
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getHome_team() {
        return home_team;
    }

    public void setHome_team(int home_team) {
        this.home_team = home_team;
    }

    public int getAway_team() {
        return away_team;
    }

    public void setAway_team(int away_team) {
        this.away_team = away_team;
    }
}
