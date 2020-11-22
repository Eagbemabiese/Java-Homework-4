/*
Edem Agbemabiese
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.util.Hashtable;

public class SongCollection {

    //Attributes
    private String name;
    private Hashtable<String, Song> songs;
    public SongCollection(String name) {
        this.name = name;
        songs = new Hashtable<String, Song>();
    }

    // Get Methods
    public Hashtable getSongs() {
        return songs;
    }
    public String getName() {
        return name;
    }

    // Set Methods
    public void setName (String name) {
        this.name = name;
    }
    public void setSongs (Hashtable songs) {
        this.songs = songs;
    }
    public Song lookUpSong(String title) {
        return this.songs.get(title);
    }
    public void addSong (Song song) {
        this.songs.put(song.getTitle(), song);
    }

    // Print Songs Method
    public void printSongs() {
        this.songs.forEach((title, song) -> {
            String artist = song.getArtist();
            String genre = song.getGenre();
            System.out.println("---------- ");
            System.out.println(title.toUpperCase());
            System.out.println(artist);
            System.out.println(genre);
        });
    }
}
