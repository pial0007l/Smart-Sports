package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Team1ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team1_list);

        final Intent intent = getIntent();
        final String matchname = intent.getStringExtra("match_name");
        final String matchDate = intent.getStringExtra("date");
        final String team1 = intent.getStringExtra("team1");
        Toast.makeText(getApplicationContext(),matchname, Toast.LENGTH_LONG).show();
        //Log.d(team1,"Team Name");

        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Player> players= db.getAllPlayers(matchname,matchDate,team1);
        PlayerAdapter adapter = new PlayerAdapter(this,players);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String players_name = players.get(i).player_Name;
                Intent intent = new Intent(Team1ListActivity.this,ViewPlayerActivity.class);
                intent.putExtra("match_name",matchname);
                intent.putExtra("date",matchDate);
                intent.putExtra("team1",team1);
                intent.putExtra("players_name",players_name);
                startActivity(intent);
            }
        });
    }
}
