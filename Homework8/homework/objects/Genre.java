package org.homework.objects;
/**
 * @author Pal Alexandra
 * This class implements an entry from the genres table from the database
 */

import lombok.Data;

@Data
public class Genre {
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
