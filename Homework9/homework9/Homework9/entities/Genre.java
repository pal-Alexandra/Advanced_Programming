package com.homework9.Homework9.entities;

/**
 * @author Pal Alexandra
 * This class describes the entity for table genres9 from the database.
 */

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "genres9")
public class Genre {
    @Id
    @GeneratedValue
    //    @Column(name = "id_genre")
    private Integer id;
    //    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genreSet")
    private Set<Album> albumSet;

    public Genre(String name) {
        this.name = name;
        this.albumSet = new HashSet<>();
    }

    public void addAlbum(Album album) {
        this.albumSet.add(album);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || (o instanceof Genre)) {
            return false;
        }
        Genre genre = (Genre) o;
        return this.id.equals(genre.id) && this.name.equals(genre.name);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Genre:");
        str.append(" id=");
        str.append(this.id);
        str.append(" /  name=");
        str.append(this.name);
        str.append("\n");
        return str.toString();
    }
}
