package com.example.maromusic;

public class Artist {
    /** Artist name for each track*/
private String mArtistName;

    private int mArtistImage;

    public Artist(int artistImage, String artistName) {
        mArtistName = artistName;
        mArtistImage = artistImage;
    }


    public int getArtistImage() {return mArtistImage;}

    /**
     * Get the Artist
     */
    public String getArtistName() { return mArtistName; }

}