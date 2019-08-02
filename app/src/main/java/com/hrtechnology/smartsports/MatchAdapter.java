package com.hrtechnology.smartsports;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MatchAdapter extends ArrayAdapter<Match> {
    Context context;
    public MatchAdapter(Activity context, ArrayList<Match> matches) {
        super(context, 0, matches);
        this.context=context;
    }
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        final Match currentMatch = getItem(position);


            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);


            TextView match_name_text_view = (TextView) listItemView.findViewById(R.id.match_name_text_view);
            match_name_text_view.setText(currentMatch.getMatch_Name());

            TextView match_date_text_view = (TextView) listItemView.findViewById(R.id.match_date_text_view);
        match_date_text_view.setText(currentMatch.getMatch_Date());

            ImageView delete_match_button = (ImageView)listItemView.findViewById(R.id.delete_match_button);
        delete_match_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //
                }
            });







        return listItemView;
    }
}
