package com.example.maromusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        gridView = findViewById(R.id.gridview);
        final ArrayList<Artist> artists = new ArrayList<Artist>();

        artists.add(new Artist(  R.drawable.adele ,"Adele" ));
        artists.add(new Artist(  R.drawable.falz ,"Falz" ));
        artists.add(new Artist(  R.drawable.lucid ,"Asa" ));
        artists.add(new Artist(  R.drawable.occ ,"Simi" ));
        artists.add(new Artist(  R.drawable.africangiant ,"Burna Boy" ));

        /**
         * This links to the NowPlayingActivity activity when an item is clicked
         * For the to work, the ArrayList has to be set to final
         */

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ArtistsActivity.this, NowPlayingActivity.class);
                intent.putExtra("artist", artists.get(i).getArtistName());
                intent.putExtra("title", "track 1");
                intent.putExtra("album_art", artists.get(i).getArtistImage());
                startActivity(intent);
            }
        });


        ArtistsAdapter adapter = new ArtistsAdapter(this, artists);

        GridView gridView =  findViewById(R.id.gridview);

        gridView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_artists, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.albumsMenu:
                startActivity(new Intent(this, AlbumsActivity.class));
                break;
            case R.id.songsMenu:
                startActivity(new Intent(this, SongsActivity.class));
                break;
            case R.id.nowPlayingMenu:
                startActivity(new Intent(this, NowPlayingActivity.class));
                break;
            case R.id.homeMenu:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
