/*
Edem Agbemabiese
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

public class Playlist extends SongCollection   {
    // Attributes
    private String description;

    // Constructor
    public Playlist(String name, String description) {
        super(name);
        this.description = description;
    }

    // Get Method
    public String getDescription() {return this.description;}

    // Set Method
    public void setDescription(String description) { this.description = description; }

}
