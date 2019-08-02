package com.hrtechnology.smartsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewMatchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_match);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        final DatabaseHandler db = new DatabaseHandler(this);

        final EditText match_Name = (EditText)findViewById(R.id.match_Name);
        final EditText match_Date = (EditText)findViewById(R.id.match_Date);
        final EditText match_Month= (EditText)findViewById(R.id.match_Month);
        final EditText match_Year = (EditText)findViewById(R.id.match_Year);
        final EditText team1_Name = (EditText)findViewById(R.id.team1_Name);
        final EditText team2_Name = (EditText)findViewById(R.id.team2_Name);
        final EditText total_Over = (EditText)findViewById(R.id.total_Over);
        LinearLayout save_Button= (LinearLayout)findViewById(R.id.save_Match);



        save_Button.setOnClickListener(new View.OnClickListener() {
            String match_name;
            String match_date;
            String match_month;
            String match_year;
            String team1_name;
            String team2_name;
            int total_over;
            String date;
            String match_status="Running";
            @Override
            public void onClick(View v) {
                this.match_name= match_Name.getText().toString();
                this.match_date=match_Date.getText().toString();
                this.match_month=match_Month.getText().toString();
                this.match_year=match_Year.getText().toString();
                this.team1_name=team1_Name.getText().toString();
                this.team2_name=team2_Name.getText().toString();
                this.total_over = Integer.parseInt(total_Over.getText().toString());
                //this.total_over = Integer.valueOf(total_Over.getText().toString());
                this.date=match_date+"/"+match_month+"/"+match_year;

                db.addNewMatche(new Match(match_name,date,0,0,total_over,team1_name,team2_name,"Pending","Pending",0,0,0));


                Intent intent = new Intent(NewMatchActivity.this,NewPlayerActivity.class);
                intent.putExtra("match_name", match_name);
                intent.putExtra("date", date);
                intent.putExtra("team1",team1_name);
                intent.putExtra("team2",team2_name);
                startActivity(intent);
                finish();

            }
        });




    }
}
