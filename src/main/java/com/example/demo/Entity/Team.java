package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by senasanioglu on 4/18/18.
 */
@Entity
@Table
public class Team {

    @Id
    @GeneratedValue
    private int team_id;

    private String team_name;

    public Team() {
    }

    public Team(String team_name) {
        this.team_name = team_name;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
