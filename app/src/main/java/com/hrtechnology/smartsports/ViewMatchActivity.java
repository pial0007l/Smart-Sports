package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewMatchActivity extends AppCompatActivity {

    String match_name_,match_date_,team1_,team2_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_match);
        DatabaseHandler db = new DatabaseHandler(this);

        LinearLayout team_1_list = (LinearLayout)findViewById(R.id.team_1_list);
        LinearLayout team_2_list = (LinearLayout)findViewById(R.id.team_2_list);
        LinearLayout score_Board = (LinearLayout)findViewById(R.id.score_Board);


        final TextView match_Name_=(TextView)findViewById(R.id.match_Name_);
        final TextView match_Date_=(TextView)findViewById(R.id.match_Date_);
        final TextView team_1_name=(TextView)findViewById(R.id.team_1_name);
        final TextView team_2_name=(TextView)findViewById(R.id.team_2_name);
        TextView total_Over_=(TextView)findViewById(R.id.total_Over_);
        TextView team_1_run=(TextView)findViewById(R.id.team_1_run);
        TextView team_2_run=(TextView)findViewById(R.id.team_2_run);
        TextView winner=(TextView)findViewById(R.id.winner);
        TextView looser=(TextView)findViewById(R.id.looser);



        final Intent intent = getIntent();
        match_name_ = intent.getStringExtra("match_name");
        match_date_ = intent.getStringExtra("match_date");
        Match match = db.getMatch(match_name_,match_date_);
        //Toast.makeText(getApplicationContext(),match_name_, Toast.LENGTH_LONG).show();
        team1_ = match.getTeam1_name().toString();
        team2_ = match.getTeam2_name().toString();

        match_Name_.setText(match_name_);
        match_Date_.setText(match_date_);
        team_1_name.setText(match.getTeam1_name().toString());
        team_2_name.setText(match.getTeam2_name().toString());
        total_Over_.setText(String.valueOf(match.getTotal_Over()));
        team_1_run.setText(String.valueOf(match.getTeam1_Run()));
        team_2_run.setText(String.valueOf(match.getTeam2_Run()));
        winner.setText(match.getWinner().toString());
        looser.setText(match.getLooser().toString());


        team_1_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1_ = team_1_name.getText().toString();
                Intent team1 = new Intent(ViewMatchActivity.this,Team1ListActivity.class);
                team1.putExtra("match_name", match_Name_.getText().toString());
                team1.putExtra("date", match_Date_.getText().toString());
                team1.putExtra("team1",team_1_name.getText().toString());
                startActivity(team1);
            }
        });

        team_2_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team2_ = team_1_name.getText().toString();
                Intent team2 = new Intent(ViewMatchActivity.this,Team1ListActivity.class);
                team2.putExtra("match_name", match_Name_.getText().toString());
                team2.putExtra("date", match_Date_.getText().toString());
                team2.putExtra("team1",team_2_name.getText().toString());
                startActivity(team2);
            }
        });

        score_Board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team1_ = team_1_name.getText().toString();
                team2_ = team_1_name.getText().toString();
                Intent scoreBoard = new Intent(ViewMatchActivity.this,SelectScoreBoard.class);
                scoreBoard.putExtra("match_name", match_Name_.getText().toString());
                scoreBoard.putExtra("date", match_Date_.getText().toString());
                scoreBoard.putExtra("team1",team_1_name.getText().toString());
                scoreBoard.putExtra("team2",team_2_name.getText().toString());
                startActivity(scoreBoard);
            }
        });


    }
}
