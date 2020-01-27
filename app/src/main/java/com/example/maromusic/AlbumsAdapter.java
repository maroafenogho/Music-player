package com.example.maromusic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsAdapter extends ArrayAdapter<Album> {

    public AlbumsAdapter(Activity context, ArrayList<Album> albums) {

        super(context, 0, albums);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_grid, parent, false);
        }

        Album currentAlbum = getItem(position);

        TextView albumTitle =  listItemView.findViewById(R.id.albumTitle);

        albumTitle.setText(currentAlbum.getAlbumTitle());

        TextView albumArtist = listItemView.findViewById(R.id.album_artist);

        albumArtist.setText(currentAlbum.getAlbumArtist());


        ImageView albumArt =  listItemView.findViewById(R.id.img_album);

        albumArt.setImageResource(currentAlbum.getAlbumArt());

        return listItemView;
    }

}