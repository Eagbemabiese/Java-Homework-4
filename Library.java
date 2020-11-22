/*
Edem Agbemabiese
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays.*;
import java.nio.file.*;
import java.nio.*;
import java.io.*;
import static java.nio.file.Files.newInputStream;

//Atributes
public class Library {
    String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;

    // Constructor
    public Library(String ownerName) {
        this.ownerName = ownerName;
        this.home = new SongCollection("home");
        this.playlists = new Hashtable<String, Playlist>();
    }

    // Get Methods
    public Hashtable getPlaylists () { return playlists; }
    public SongCollection getHome () { return home; }
    public String getOwnerName () { return ownerName; }

    public void uploadDemoSongs() {
        Path file= Paths.get("./demo_songs.txt");
        InputStream inputDevice = null;
        try {

            inputDevice = newInputStream(file);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputDevice));
            String s=null;
            String[] songDetails;

            while ((s=reader.readLine()) != null) {

                songDetails = s.split(",");
                System.out.println(Arrays.toString(songDetails));

                String title = songDetails[0];
                String artist = songDetails[1];
                String genre= songDetails[2];

                Song song = new Song(title, artist, genre);
                this.home.addSong(song);
            }
            inputDevice.close();

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
    //Create Playlist Method
    public Playlist createPlaylist (Scanner input) {
        System.out.println("Playlist name:  ");
        String name = input.nextLine();
        System.out.println("Description:  ");
        String description = input.nextLine();
        Playlist playlist = new Playlist (name, description);
        char addAnother='n';
        do {
            System.out.println("Adding to your " + name + " playlist");
            String title, artist, genre;

            System.out.print("Song name: ");
            title = input.nextLine();

            System.out.print("Artist name: ");
            artist = input.nextLine();

            System.out.print("Genre: ");
            genre = input.nextLine();

            playlist.addSong(new Song(title, artist, genre));
            System.out.println("Would you like to add another song? (y/n) ");

            addAnother = input.nextLine().charAt(0);
        } while (Character.toLowerCase(addAnother) == 'y');
        return playlist;
    }

    //Add Playlist
    public void addPlaylist (Playlist playlist) {
        this.playlists.put(playlist.getName(), playlist);
        playlist.getSongs().forEach((title, song) -> {
            this.home.addSong((Song) song);
        });
    }

    //Print Library to Output Method
    public void printLibrary () {
        System.out.println("LIBRARY OWNER: " + ownerName) ;
        System.out.println("SONGS IN LIBRARY: ");
        this.home.printSongs();
        this.playlists.forEach((name, playlist) -> {
            System.out.println();
            System.out.println("Your playlist " + playlist.getName() + ", on Tidal.");
            System.out.println(playlist.getName() + "'s description: " + playlist.getDescription());
            System.out.println("=============");
            playlist.printSongs();
        });

    }

}
