package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreBoard extends AppCompatActivity {
    int score,wicket_,over;
    String onStrick;
    float total_Ball=0;
    int ball_=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        final DatabaseHandler db = new DatabaseHandler(this);

        final Intent intent = getIntent();
        final String matchname = intent.getStringExtra("match_name");
        final String matchDate = intent.getStringExtra("date");
        final String team1 = intent.getStringExtra("team1");
        final String team2 = intent.getStringExtra("team2");
        final String flag = intent.getStringExtra("flag");
        final Match match = db.getMatch(matchname,matchDate);

        final TextView mainscore = (TextView)findViewById(R.id.mainscore);
        TextView wicket = (TextView)findViewById(R.id.mainwicket);


        final TextView ball1_text = (TextView)findViewById(R.id.ball1_text);
        final TextView ball2_text = (TextView)findViewById(R.id.ball2_text);
        final TextView ball3_text = (TextView)findViewById(R.id.ball3_text);
        final TextView ball4_text = (TextView)findViewById(R.id.ball4_text);
        final TextView ball5_text = (TextView)findViewById(R.id.ball5_text);
        final TextView ball6_text = (TextView)findViewById(R.id.ball6_text);
        final TextView ball7_text = (TextView)findViewById(R.id.ball7_text);
        final TextView ball8_text = (TextView)findViewById(R.id.ball8_text);
        final TextView ball9_text = (TextView)findViewById(R.id.ball9_text);

        final TextView match_Over = (TextView)findViewById(R.id.match_Over);


        final LinearLayout ball1 = (LinearLayout)findViewById(R.id.ball1);
        final LinearLayout ball2 = (LinearLayout)findViewById(R.id.ball2);
        final LinearLayout ball3 = (LinearLayout)findViewById(R.id.ball3);
        final LinearLayout ball4 = (LinearLayout)findViewById(R.id.ball4);
        final LinearLayout ball5 = (LinearLayout)findViewById(R.id.ball5);
        final LinearLayout ball6 = (LinearLayout)findViewById(R.id.ball6);
        final LinearLayout ball7 = (LinearLayout)findViewById(R.id.ball7);
        final LinearLayout ball8 = (LinearLayout)findViewById(R.id.ball8);
        final LinearLayout ball9 = (LinearLayout)findViewById(R.id.ball9);




        LinearLayout button0 = (LinearLayout)findViewById(R.id.score0);
        LinearLayout button1 = (LinearLayout)findViewById(R.id.score1);
        LinearLayout button2 = (LinearLayout)findViewById(R.id.score2);
        LinearLayout button3 = (LinearLayout)findViewById(R.id.score3);
        LinearLayout button4 = (LinearLayout)findViewById(R.id.score4);
        LinearLayout button6 = (LinearLayout)findViewById(R.id.score6);
        LinearLayout buttonW = (LinearLayout)findViewById(R.id.wicket);
        LinearLayout buttonWd = (LinearLayout)findViewById(R.id.wide);
        LinearLayout buttonN = (LinearLayout)findViewById(R.id.noball);



        if(flag.equals("team1")){
            mainscore.setText(String.valueOf(match.getTeam1_Run()));
            over = match.getOver();
            match_Over.setText("Over: "+String.valueOf(match.getOver())+"."+String.valueOf((int)total_Ball));
            score=match.getTeam1_Run();
            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;

                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=0;
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/
                if(ball_==0 && total_Ball>0){
                    ball1.setVisibility(View.VISIBLE);
                    ball_=1;
                    ball1_text.setText(String.valueOf(0));
                }else if(ball_==1){
                    ball2.setVisibility(View.VISIBLE);
                    ball_=2;
                    ball2_text.setText(String.valueOf(0));
                }else if(ball_==2){
                    ball3.setVisibility(View.VISIBLE);
                    ball_=3;
                    ball3_text.setText(String.valueOf(0));
                }else if(ball_==3){
                    ball4.setVisibility(View.VISIBLE);
                    ball_=4;
                    ball4_text.setText(String.valueOf(0));
                }else if(ball_==4){
                    ball5.setVisibility(View.VISIBLE);
                    ball_=5;
                    ball5_text.setText(String.valueOf(0));
                }else if(ball_==5){
                    ball6.setVisibility(View.VISIBLE);
                    ball_=6;
                    ball6_text.setText(String.valueOf(0));
                }else if(ball_==6){
                    ball7.setVisibility(View.VISIBLE);
                    ball_=7;
                    ball7_text.setText(String.valueOf(0));
                }else if(ball_==7){
                    ball8.setVisibility(View.VISIBLE);
                    ball_=8;
                    ball8_text.setText(String.valueOf(0));
                }else if(ball_==8){
                    ball9.setVisibility(View.VISIBLE);
                    ball_=9;
                    ball9_text.setText(String.valueOf(0));
                }
                /**********************************Run By Ball End******************************/

                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver()));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;

                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(1));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(1));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(1));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(1));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(1));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(1));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(1));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(1));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(1));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball>=6){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=2;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/


                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(2));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(2));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(2));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(2));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(2));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(2));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(2));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(2));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(2));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=3;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/


                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(3));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(3));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(3));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(3));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(3));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(3));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(3));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(3));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(3));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=4;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(4));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(4));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(4));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(4));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(4));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(4));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(4));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(4));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(4));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/


                    /**********************************Score logic Start********************************/
                    score+=6;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(6));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(6));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(6));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(6));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(6));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(6));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(6));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(6));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(6));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            buttonW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("W");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("W");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("W");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("W");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("W");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("W");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("W");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("W");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("W");
                    }
                    /**********************************Run By Ball End******************************/
                    wicket_+=1;


                }
            });
            buttonWd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("Wd");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("Wd");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("Wd");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("Wd");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("Wd");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("Wd");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("Wd");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("Wd");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("Wd");
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            buttonN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),score,match.team2_Run);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam1_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("N");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("N");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("N");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("N");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("N");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("N");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("N");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("N");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("N");
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
/***********************************************************TEAM 2************************************************************/
        }else if(flag.equals("team2")){
            mainscore.setText(String.valueOf(match.getTeam2_Run()));
            over = match.getOver();
            match_Over.setText("Over: "+String.valueOf(match.getOver())+"."+String.valueOf((int)total_Ball));
            score=match.getTeam2_Run();
            button0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;

                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=0;
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/
                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(0));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(0));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(0));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(0));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(0));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(0));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(0));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(0));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(0));
                    }
                    /**********************************Run By Ball End******************************/

                }
            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver()));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;

                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(1));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(1));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(1));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(1));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(1));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(1));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(1));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(1));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(1));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball>=6){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=2;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/


                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(2));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(2));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(2));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(2));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(2));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(2));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(2));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(2));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(2));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=3;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/


                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(3));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(3));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(3));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(3));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(3));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(3));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(3));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(3));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(3));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Score logic Start********************************/
                    score+=4;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(4));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(4));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(4));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(4));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(4));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(4));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(4));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(4));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(4));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/


                    /**********************************Score logic Start********************************/
                    score+=6;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText(String.valueOf(6));
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText(String.valueOf(6));
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText(String.valueOf(6));
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText(String.valueOf(6));
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText(String.valueOf(6));
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText(String.valueOf(6));
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText(String.valueOf(6));
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText(String.valueOf(6));
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText(String.valueOf(6));
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            buttonW.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /**********************************Over logic start**********************************/
                    if(total_Ball==5){
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            total_Ball=0;
                            over+=1;
                            //Toast.makeText(getApplicationContext(),String.valueOf(over), Toast.LENGTH_LONG).show();
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));

                            ball1.setVisibility(View.INVISIBLE);
                            ball2.setVisibility(View.INVISIBLE);
                            ball3.setVisibility(View.INVISIBLE);
                            ball4.setVisibility(View.INVISIBLE);
                            ball5.setVisibility(View.INVISIBLE);
                            ball6.setVisibility(View.INVISIBLE);
                            ball7.setVisibility(View.INVISIBLE);
                            ball8.setVisibility(View.INVISIBLE);
                            ball9.setVisibility(View.INVISIBLE);
                            ball_=0;
                        }
                    }else {
                        if(match.total_Over<=over){
                            over=0;
                            Match ove = new Match(match.getMatch_Name(),match.getMatch_Date(),over);
                            db.updateMatchOver(ove);
                        }else {
                            //Toast.makeText(getApplicationContext(),String.valueOf(match.total_Over), Toast.LENGTH_LONG).show();
                            total_Ball+=1;
                            Match m3 = db.getMatch(match.getMatch_Name(),match.getMatch_Date());
                            match_Over.setText("Over: "+String.valueOf(m3.getOver())+"."+String.valueOf((int)total_Ball));
                        }
                    }
                    /**********************************Over logic End**********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("W");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("W");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("W");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("W");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("W");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("W");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("W");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("W");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("W");
                    }
                    /**********************************Run By Ball End******************************/
                    wicket_+=1;


                }
            });
            buttonWd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("Wd");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("Wd");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("Wd");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("Wd");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("Wd");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("Wd");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("Wd");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("Wd");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("Wd");
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
            buttonN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    /**********************************Score logic Start********************************/
                    score+=1;
                    mainscore.setText(String.valueOf(score));
                    mainscore.setText(String.valueOf(score));
                    Match m = new Match(match.getMatch_Name(),match.getMatch_Date(),match.team1_Run,score);
                    db.updateMatchScore(m);
                    Match m2 = db.getMatch(match.match_Name,match.match_Date);
                    mainscore.setText(String.valueOf(m2.getTeam2_Run()));
                    /**********************************Score logic End********************************/

                    /**********************************Run By Ball Start******************************/


                    if(ball_==0 && total_Ball>0){
                        ball1.setVisibility(View.VISIBLE);
                        ball_=1;
                        ball1_text.setText("N");
                    }else if(ball_==1){
                        ball2.setVisibility(View.VISIBLE);
                        ball_=2;
                        ball2_text.setText("N");
                    }else if(ball_==2){
                        ball3.setVisibility(View.VISIBLE);
                        ball_=3;
                        ball3_text.setText("N");
                    }else if(ball_==3){
                        ball4.setVisibility(View.VISIBLE);
                        ball_=4;
                        ball4_text.setText("N");
                    }else if(ball_==4){
                        ball5.setVisibility(View.VISIBLE);
                        ball_=5;
                        ball5_text.setText("N");
                    }else if(ball_==5){
                        ball6.setVisibility(View.VISIBLE);
                        ball_=6;
                        ball6_text.setText("N");
                    }else if(ball_==6){
                        ball7.setVisibility(View.VISIBLE);
                        ball_=7;
                        ball7_text.setText("N");
                    }else if(ball_==7){
                        ball8.setVisibility(View.VISIBLE);
                        ball_=8;
                        ball8_text.setText("N");
                    }else if(ball_==8){
                        ball9.setVisibility(View.VISIBLE);
                        ball_=9;
                        ball9_text.setText("N");
                    }
                    /**********************************Run By Ball End******************************/
                }
            });
        }



    }
}
