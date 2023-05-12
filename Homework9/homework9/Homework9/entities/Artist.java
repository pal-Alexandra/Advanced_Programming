package com.homework9.Homework9.entities;

/**
 * @author Pal Alexandra
 * This class describes the entity for table artists9 from the database.
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "artists9")
public class Artist {
    @Id
    @GeneratedValue
    //  @Column(name = "id")
    private Integer id;
    //  @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private Set<Album> albums;

    public Artist(String name) {
        this.name = name;
        albums = new HashSet<>();
    }

    public void setAlbumList(Set<Album> albumList) {
        this.albums = albumList;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || (o instanceof Artist)) {
            return false;
        }
        Artist artist = (Artist) o;
        return this.id.equals(artist.id) && this.name.equals(artist.name);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Artist:");
        str.append(" id=");
        str.append(this.id);
        str.append(" /  name=");
        str.append(this.name);
        str.append("\n albums=[ ");
        for (Album album : this.albums) {
            str.append("Album(id=");
            str.append(album.getId());
            str.append(" / name=");
            str.append(album.getName());
            str.append(") ");
        }
        str.append("]\n");
        return str.toString();
    }
}
