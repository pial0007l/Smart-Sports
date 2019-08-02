package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_player);
        DatabaseHandler db = new DatabaseHandler(this);

        TextView player_name = (TextView)findViewById(R.id.player_name);
        TextView team_name = (TextView)findViewById(R.id.team_name);
        TextView run = (TextView)findViewById(R.id.run);
        TextView total_Ball_ = (TextView)findViewById(R.id.total_Ball_);
        TextView batting_over = (TextView)findViewById(R.id.batting_over);
        TextView bowling_over = (TextView)findViewById(R.id.bowling_over);
        TextView match_Date_ = (TextView)findViewById(R.id.match_Date_);


        final Intent intent = getIntent();
        final String matchname = intent.getStringExtra("match_name");
        final String matchDate = intent.getStringExtra("date");
        final String team1 = intent.getStringExtra("team1");
        final String players_name = intent.getStringExtra("players_name");

        Player player = db.getPlayer(matchname,matchDate,team1,players_name);

        player_name.setText(player.getPlayer_Name().toString());
        team_name.setText(player.getTeam_name().toString());
        run.setText(String.valueOf(player.getPlayer_run()));
        total_Ball_.setText(String.valueOf(player.getPlayer_Ball()));
        batting_over.setText(String.valueOf(player.getBatting_over()));
        bowling_over.setText(String.valueOf(player.getBowling_over()));
        match_Date_.setText(matchDate.toString());




    }
}
