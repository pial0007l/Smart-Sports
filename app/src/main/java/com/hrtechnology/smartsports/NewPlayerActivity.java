package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class NewPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        final DatabaseHandler db = new DatabaseHandler(this);

        final EditText player1Name_ = (EditText)findViewById(R.id.player1_name_);
        final EditText player2Name_ = (EditText)findViewById(R.id.player2_name_);
        final EditText bowler_Name_ = (EditText)findViewById(R.id.bowler_name_);
        LinearLayout save_button = (LinearLayout)findViewById(R.id.save_player);


        final Intent intent = getIntent();
        final String matchname = intent.getStringExtra("match_name");
        final String matchDate = intent.getStringExtra("date");
        final String team1 = intent.getStringExtra("team1");
        final String team2 = intent.getStringExtra("team2");


        save_button.setOnClickListener(new View.OnClickListener() {
            String player1Name;
            String player2Name;
            String bowlerName;
            @Override
            public void onClick(View view) {
                player1Name = player1Name_.getText().toString();
                player2Name = player2Name_.getText().toString();
                bowlerName = bowler_Name_.getText().toString();

                try {
                    db.addNewPlayer(new Player(player1Name,matchname,team1,matchDate,0,0,0,0));
                    db.addNewPlayer(new Player(player2Name,matchname,team1,matchDate,0,0,0,0));
                    db.addNewPlayer(new Player(bowlerName,matchname,team2,matchDate,0,0,0,0));
                    Toast toast   = Toast.makeText(getApplicationContext(), "Sucess", Toast.LENGTH_SHORT);
                    toast.show();
                } catch (Exception e){
                    String err  = e.toString();
                    Toast toast = Toast.makeText(getApplicationContext(), err,Toast.LENGTH_SHORT);
                    toast.show();
                }

                Intent intent1 =new Intent(NewPlayerActivity.this,ScoreBoard.class);
                intent1.putExtra("match_name", matchname);
                intent1.putExtra("date", matchDate);
                startActivity(intent1);
                finish();
            }
        });
    }
}
