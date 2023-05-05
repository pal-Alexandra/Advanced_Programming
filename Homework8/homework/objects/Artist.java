package org.homework.objects;
/**
 * @author Pal Alexandra
 * This class implements an entry from the artists table from the database
 */

import lombok.Data;

@Data
public class Artist {

    private int id;
    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
