package com.hrtechnology.smartsports;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerAdapter extends ArrayAdapter<Player> {
    Context context;
    public PlayerAdapter(Activity context, ArrayList<Player> players) {
        super(context, 0, players);
        this.context=context;
    }
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        final Player currentPlayer = getItem(position);


        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item2, parent, false);


        TextView player_name_text_view = (TextView) listItemView.findViewById(R.id.player_name_text_view);
        player_name_text_view.setText(currentPlayer.getPlayer_Name());

        TextView player_run_text_view = (TextView) listItemView.findViewById(R.id.player_run_text_view);
        player_run_text_view.setText(String.valueOf(currentPlayer.getPlayer_run()));

        return listItemView;
    }
}
