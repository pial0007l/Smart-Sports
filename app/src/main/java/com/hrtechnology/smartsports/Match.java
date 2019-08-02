package com.hrtechnology.smartsports;

import java.io.Serializable;

public class Match implements Serializable {
    String match_Name;
    String match_Date;
    int team1_Run;
    int team2_Run;
    int total_Over;
    String team1_name;
    String team2_name;
    String winner;
    String looser;
    int over;
    int team1wicket;
    int team2wicketl;



    public Match(){};
    public Match(String match_Name,String match_Date,int team1_Run,int team2_Run,int total_Over,String team1_name,String team2_name,String winner,String looser,int over,int team1wicket, int team2wicket){
        this.match_Name=match_Name;
        this.match_Date=match_Date;
        this.team1_name=team1_name;
        this.team2_name=team2_name;
        this.team1_Run=team1_Run;
        this.team2_Run=team2_Run;
        this.winner=winner;
        this.looser=looser;
        this.total_Over=total_Over;
        this.over=over;
        this.team1wicket=team1wicket;
        this.team2wicketl=team2wicket;
    };
    public Match(String match_Name,String match_Date){
        this.match_Name=match_Name;
        this.match_Date=match_Date;
    };
    public Match(String match_Name,String match_Date,int over){
        this.match_Name=match_Name;
        this.match_Date=match_Date;
        this.over=over;
    };
    public Match(String match_Name,String match_Date,int team1_run,int team2_run){
        this.match_Name=match_Name;
        this.match_Date=match_Date;
        this.team1_Run=team1_run;
        this.team2_Run=team2_run;
    };

    public Match(String match_Name,String match_Date,String team1wicket,int team2wicket){
        this.match_Name=match_Name;
        this.match_Date=match_Date;
        this.team1wicket=Integer.parseInt(team1wicket);
        this.team2wicketl=team2wicket;
    };




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

    public int getTeam1_Run() {
        return team1_Run;
    }

    public void setTeam1_Run(int team1_Run) {
        this.team1_Run = team1_Run;
    }

    public int getTeam2_Run() {
        return team2_Run;
    }

    public void setTeam2_Run(int team2_Run) {
        this.team2_Run = team2_Run;
    }

    public int getTotal_Over() {
        return total_Over;
    }

    public void setTotal_Over(int total_Over) {
        this.total_Over = total_Over;
    }

    public String getTeam1_name() {
        return team1_name;
    }

    public void setTeam1_name(String team1_name) {
        this.team1_name = team1_name;
    }

    public String getTeam2_name() {
        return team2_name;
    }

    public void setTeam2_name(String team2_name) {
        this.team2_name = team2_name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLooser() {
        return looser;
    }

    public void setLooser(String looser) {
        this.looser = looser;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getTeam1wicket() {
        return team1wicket;
    }

    public void setTeam1wicket(int team1wicket) {
        this.team1wicket = team1wicket;
    }

    public int getTeam2wicketl() {
        return team2wicketl;
    }

    public void setTeam2wicketl(int team2wicketl) {
        this.team2wicketl = team2wicketl;
    }
}
