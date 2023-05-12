package com.homework9.Homework9.repositories;

/**
 * @author Pal Alexandra
 * This class describes the repository for the entity genre (for table genres9) from the database.
 */

import com.homework9.Homework9.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    public List<Genre> findByName(String name);

    public Genre findById(int id);
}
