package com.homework9.Homework9.repositories;

/**
 * @author Pal Alexandra
 * This class describes the repository for the entity album (for table albums9) from the database.
 */

import com.homework9.Homework9.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    List<Album> findByName(String name);

     Album findById(int id);
}
