package com.example.maromusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistsAdapter extends ArrayAdapter<Artist> {

public ArtistsAdapter(Activity context, ArrayList<Artist> artists) {
        super(context, 0, artists);
        }


@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(
        R.layout.artists_grid, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Artist currentArtist = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView albumTitle =  listItemView.findViewById(R.id.artist_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        albumTitle.setText(currentArtist.getArtistName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        ImageView albumArtist = listItemView.findViewById(R.id.img_artist);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        albumArtist.setImageResource(currentArtist.getArtistImage());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
        }
}