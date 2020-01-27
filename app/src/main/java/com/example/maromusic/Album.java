package com.example.maromusic;

public class Album {

    /** Artist name for each track*/
    private String mAlbumArtist;

    /** Album title */
    private String mAlbumTitle;

    private int mAlbumArt;

    /**
     * Create a new Song object.
     *
     * @param albumTitle is the title of each track
     * @param albumArtist is the name of the artist who sang the song
     */
    public Album(int albumArt, String albumTitle, String albumArtist) {
        mAlbumArtist = albumArtist;
        mAlbumTitle = albumTitle;
        mAlbumArt = albumArt;
    }


    public int getAlbumArt() {return mAlbumArt;}

    /**
     * Get the song title
     */
    public String getAlbumTitle() { return mAlbumTitle ; }

    /**
     * Get the Song Artist
     */
    public String getAlbumArtist() { return mAlbumArtist; }

}
