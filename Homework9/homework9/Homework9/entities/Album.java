package com.homework9.Homework9.entities;

/**
 * @author Pal Alexandra
 * This class describes the entity for table albums9 from the database.
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "albums9")
public class Album {

    @Id
    @GeneratedValue
    //  @Column(name = "id_album")
    private Integer id;

    //  @Column(name = "release_year")
    private int releaseYear;

    //  @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artist", nullable = false)
    private Artist artist;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "album_genres9",
            joinColumns =
            @JoinColumn(name = "id_album")
            ,
            inverseJoinColumns =
            @JoinColumn(name = "id_genre"))
    private Set<Genre> genreSet;

    public Album(int releaseYear, String name) {
        this.releaseYear = releaseYear;
        this.name = name;
        this.genreSet = new HashSet<>();
    }

    public void setGenres(Set<Genre> albumGenres) {
        genreSet = albumGenres;
    }

    public void addGenre(Genre genre) {
        this.genreSet.add(genre);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Album)) {
            return false;
        }
        Album album = (Album) o;
        return this.id.equals(album.id) && this.name.equals(album.name);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Album:");
        str.append("( id=");
        str.append(this.id);
        str.append(" /  title=");
        str.append(this.name);
        str.append(" /  releaseYear=");
        str.append(this.releaseYear);
        str.append(" /  artist=Artist(id=");
        str.append(this.artist.getId());
        str.append(" / name=");
        str.append(this.artist.getName());
        str.append(")\n genres=[ ");
        for (Genre genre : this.genreSet) {
            str.append("Genre(name=");
            str.append(genre.getName());
            str.append(") ");
        }
        str.append("]\n");
        return str.toString();
    }
}
