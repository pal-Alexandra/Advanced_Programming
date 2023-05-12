package com.compulsory.laboratory9.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pal Alexandra
 * This class describes the entity for table artists9 from the database.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "artists9")
public class Artist {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }


}
