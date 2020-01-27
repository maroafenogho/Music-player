package com.example.maromusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        listView = findViewById(R.id.list);
        final ArrayList<Song> songs = new ArrayList<Song>();


        songs.add(new Song( R.drawable.adele ,"Hello", "Adele", "25"));
        songs.add(new Song( R.drawable.adele ,"Water under the bridge", "Adele", "25"));
        songs.add(new Song( R.drawable.adele ,"River Lea", "Adele", "25"));
        songs.add(new Song( R.drawable.adele ,"I miss you", "Adele", "25"));
        songs.add(new Song( R.drawable.lucid ,"9 lives", "Asa", "lucid"));
        songs.add(new Song( R.drawable.lucid ,"Murder in The USA", "Asa", "lucid"));
        songs.add(new Song( R.drawable.lucid ,"Torn", "Asa", "lucid"));
        songs.add(new Song( R.drawable.lucid ,"Happy people", "Asa", "lucid"));
        songs.add(new Song( R.drawable.falz ,"Child of the World", "Falz", "27"));
        songs.add(new Song( R.drawable.africangiant ,"Wetin man go do", "Burna Boy", "African Giant"));
        songs.add(new Song( R.drawable.simisola ,"Remind me", "Simi", "Simisola"));
        songs.add(new Song( R.drawable.simisola ,"Joromi", "Simi", "Simisola"));
        songs.add(new Song( R.drawable.simisola ,"Ayo", "Simi", "Omo Charlie Champagne"));
        songs.add(new Song( R.drawable.simisola ,"Charlie", "Simi", "Simisola"));
        songs.add(new Song( R.drawable.chemistry ,"Chemistry", "Simi & Falz", "Chemistry"));

        /**
         * This links to the NowPlayingActivity activity when an item is clicked
         * For the to work, the ArrayList has to be set to final
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SongsActivity.this, NowPlayingActivity.class);
                intent.putExtra("album", songs.get(i).getAlbumTitle());
                intent.putExtra("artist", songs.get(i).getSongArtist());
                intent.putExtra("title", songs.get(i).getSongTitle());
                intent.putExtra("album_art", songs.get(i).getAlbumArt());
                startActivity(intent);
            }
        });
        listView.setAdapter(new SongAdapter(this, songs));


        SongAdapter adapter = new SongAdapter(this, songs);


        ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);
    }

    /**
     *
     * @param menu creates a menu list that can be used to navigate to other activities
     *
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_all_songs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.albumsMenu:
                startActivity(new Intent(this, AlbumsActivity.class));
                break;
            case R.id.nowPlayingMenu:
                startActivity(new Intent(this, NowPlayingActivity.class));
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
