package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class OneDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_day);


        LinearLayout new_match = (LinearLayout)findViewById(R.id.new_Match);
        LinearLayout match_List = (LinearLayout)findViewById(R.id.match_List);



        new_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OneDay.this,NewMatchActivity.class);
                startActivity(i);
            }
        });
        match_List.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OneDay.this,MatchListActivity.class);
                startActivity(intent);
            }
        });
    }
}
