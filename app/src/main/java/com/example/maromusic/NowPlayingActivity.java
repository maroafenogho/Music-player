package com.example.maromusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    boolean playing = true;
    TextView artist;
    TextView title;
    TextView album;
    ImageView albumArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        artist = findViewById(R.id.artist);
        title = findViewById(R.id.title);
        album = findViewById(R.id.album);
        albumArt = findViewById(R.id.album_art);
        if (getIntent().hasExtra("album"))
            album.setText(getIntent().getStringExtra("album"));
        if (getIntent().hasExtra("artist"))
            artist.setText(getIntent().getStringExtra("artist"));
        if (getIntent().hasExtra("title"))
            title.setText(getIntent().getStringExtra("title"));
        if (getIntent().hasExtra("album_art"))
            albumArt.setImageResource(getIntent().getIntExtra("album_art", R.drawable.album));

    }

    public void clickPlay(View view) {
        playing = !playing;
        ((ImageView) findViewById(R.id.playBt)).setImageResource(playing ? R.drawable.ic_baseline_play_arrow_24px
                : R.drawable.ic_baseline_pause_24px);

    }

    /**
     * This links to the NowPlayingActivity activity when an item is clicked
     * For the to work, the ArrayList has to be set to final
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_now_playing, menu);
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