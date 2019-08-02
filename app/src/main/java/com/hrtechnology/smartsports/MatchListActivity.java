package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MatchListActivity extends AppCompatActivity {

    private Object Match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);
        DatabaseHandler db = new DatabaseHandler(this);
        final ArrayList<Match> matches= db.getAllMatches();
        MatchAdapter adapter = new MatchAdapter(this,matches);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String match_name = matches.get(i).match_Name;
                String match_date = matches.get(i).match_Date;
                Intent intent = new Intent(MatchListActivity.this,ViewMatchActivity.class);
                intent.putExtra("match_name", match_name);
                intent.putExtra("match_date", match_date);
                startActivity(intent);
            }
        });
    }
}
