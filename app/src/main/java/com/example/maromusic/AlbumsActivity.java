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

public class AlbumsActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        gridView = findViewById(R.id.gridview);
        final ArrayList<Album> albums = new ArrayList<Album>();

        albums.add(new Album( R.drawable.adele ,"25", "Adele"));
        albums.add(new Album( R.drawable.falz ,"27", "Falz"));
        albums.add(new Album( R.drawable.chemistry ,"Chemistry", "Falz & Simi"));
        albums.add(new Album( R.drawable.lucid ,"Lucid", "Asa"));
        albums.add(new Album( R.drawable.occ ,"Omo Charlie Champagne", "Simi"));
        albums.add(new Album( R.drawable.africangiant ,"African Giant", "Burna Boy"));
        albums.add(new Album( R.drawable.simisola ,"Simisola", "Simi"));
        albums.add(new Album( R.drawable.adele ,"25", "Adele"));
        albums.add(new Album( R.drawable.falz ,"27", "Falz"));
        albums.add(new Album( R.drawable.chemistry ,"Chemistry", "Falz & Simi"));
        albums.add(new Album( R.drawable.lucid ,"Lucid", "Asa"));
        albums.add(new Album( R.drawable.occ ,"Omo Charlie Champagne", "Simi"));
        albums.add(new Album( R.drawable.africangiant ,"African Giant", "Burna Boy"));
        albums.add(new Album( R.drawable.simisola ,"Simisola", "Simi"));

        /**
         * This links to the NowPlayingActivity activity when an item is clicked
         * For the to work, the ArrayList has to be set to final
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AlbumsActivity.this, NowPlayingActivity.class);
                intent.putExtra("album", albums.get(i).getAlbumTitle());
                intent.putExtra("artist", albums.get(i).getAlbumArtist());
                intent.putExtra("title", "track 1");
                intent.putExtra("album_art", albums.get(i).getAlbumArt());
                startActivity(intent);
            }
        });

        AlbumsAdapter adapter = new AlbumsAdapter(this, albums);

        GridView gridView =  findViewById(R.id.gridview);

        gridView.setAdapter(adapter);
    }
    /**
     * This links to the NowPlayingActivity activity when an item is clicked
     * For the to work, the ArrayList has to be set to final
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_albums, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nowPlayingMenu:
                startActivity(new Intent(this, NowPlayingActivity.class));
                break;
            case R.id.songsMenu:
                startActivity(new Intent(this, SongsActivity.class));
                break;
            case R.id.artistsMenu:
                startActivity(new Intent(this, ArtistsActivity.class));
                break;
            case R.id.homeMenu:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

