package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SelectScoreBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_score_board);

        LinearLayout team_1_scoreBoard = (LinearLayout)findViewById(R.id.team_1_scoreBoard);
        LinearLayout team_2_scoreBoard = (LinearLayout)findViewById(R.id.team_2_scoreBoard);

        final Intent intent = getIntent();
        final String matchname = intent.getStringExtra("match_name");
        final String matchDate = intent.getStringExtra("date");
        final String team1 = intent.getStringExtra("team1");
        final String team2 = intent.getStringExtra("team2");

        team_1_scoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectScoreBoard.this,ScoreBoard.class);
                i.putExtra("match_name", matchname);
                i.putExtra("date",matchDate );
                i.putExtra("team1",team1);
                i.putExtra("team2",team2);
                i.putExtra("flag","team1");
                startActivity(i);
            }
        });
        team_2_scoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectScoreBoard.this,ScoreBoard.class);
                i.putExtra("match_name", matchname);
                i.putExtra("date",matchDate );
                i.putExtra("team2",team2);
                i.putExtra("team1",team1);
                i.putExtra("flag","team2");
                startActivity(i);
            }
        });
    }
}
