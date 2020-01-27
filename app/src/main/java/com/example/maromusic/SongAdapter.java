package com.example.maromusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {

        super(context, 0, songs);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView songTitle =  listItemView.findViewById(R.id.song_title);

        songTitle.setText(currentSong.getSongTitle());

        TextView songArtist = listItemView.findViewById(R.id.song_artist);

        songArtist.setText(currentSong.getSongArtist());

        TextView albumTitle =  listItemView.findViewById(R.id.album_title);

        albumTitle.setText(currentSong.getAlbumTitle());

        ImageView albumArt =  listItemView.findViewById(R.id.album_art);

        albumArt.setImageResource(currentSong.getAlbumArt());


        return listItemView;
    }

}
