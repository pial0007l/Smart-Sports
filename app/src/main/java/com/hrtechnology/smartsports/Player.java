package com.hrtechnology.smartsports;

import java.io.Serializable;

public class Player implements Serializable {
    String player_Name;
    String match_Name;
    String match_Date;
    String team_name;
    int player_run;
    int player_Ball;
    float batting_over;
    float bowling_over;
    public Player(){};

    public String getPlayer_Name() {
        return player_Name;
    }

    public void setPlayer_Name(String player_Name) {
        this.player_Name = player_Name;
    }

    public String getMatch_Name() {
        return match_Name;
    }

    public void setMatch_Name(String match_Name) {
        this.match_Name = match_Name;
    }

    public String getMatch_Date() {
        return match_Date;
    }

    public void setMatch_Date(String match_Date) {
        this.match_Date = match_Date;
    }

    public int getPlayer_run() {
        return player_run;
    }

    public void setPlayer_run(int player_run) {
        this.player_run = player_run;
    }

    public int getPlayer_Ball() {
        return player_Ball;
    }

    public void setPlayer_Ball(int player_Ball) {
        this.player_Ball = player_Ball;
    }

    public float getBatting_over() {
        return batting_over;
    }

    public void setBatting_over(float batting_over) {
        this.batting_over = batting_over;
    }

    public float getBowling_over() {
        return bowling_over;
    }

    public void setBowling_over(float bowling_over) {
        this.bowling_over = bowling_over;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Player(String player_Name, String match_Name, String team_name, String match_Date, int player_run, int player_Ball, float batting_over, float bowling_over){
        this.player_Name = player_Name;
        this.match_Name=match_Name;
        this.team_name=team_name;
        this.match_Date=match_Date;
        this.player_run=player_run;
        this.player_Ball=player_Ball;
        this.batting_over=batting_over;
        this.bowling_over=bowling_over;
    };
    public  Player (String player_Name,int player_run){
        this.player_Name=player_Name;
        this.player_run=player_run;
    };

}
