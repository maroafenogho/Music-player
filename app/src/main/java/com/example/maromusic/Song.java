package com.example.maromusic;

public class Song {
       /** Song title for each track */
        private String mSongTitle;

        /** Artist name for each track*/
        private String mSongArtist;

        /** Album title */
         private String mAlbumTitle;

         private int mAlbumArt;

        /**
         * Create a new Song object.
         *
         * @param songTitle is the title of each track
         * @param songArtist is the name of the artist who sang the song
         */
        public Song(int albumArt,String songTitle, String songArtist, String albumTitle) {
            mSongTitle = songTitle;
            mSongArtist = songArtist;
            mAlbumTitle = albumTitle;
            mAlbumArt = albumArt;
        }


        public int getAlbumArt() {return mAlbumArt;}

        /**
         * Get the song title
         */
        public String getSongTitle() { return mSongTitle; }

        /**
         * Get the Song Artist
         */
        public String getSongArtist() { return mSongArtist; }

        //get song album

        public String getAlbumTitle() { return mAlbumTitle; }


}
