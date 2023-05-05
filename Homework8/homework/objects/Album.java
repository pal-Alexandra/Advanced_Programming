package org.homework.objects;
/**
 * @author Pal Alexandra
 * This class implements an entry from the albums table from the database
 */

import lombok.Data;

@Data
public class Album {

    private int id;
    private int releaseYear;
    private String title;

    private String artist;

    private String genre;

    public Album(int id, int releaseYear, String title, String artist, String genre) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", release_year=" + releaseYear +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
