package com.compulsory.laboratory9.repositories;

/**
 * @author Pal Alexandra
 * This class describes the repository for the entity artist (for table artists9) from the database.
 */

import com.compulsory.laboratory9.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    public List<Artist> findByName(String name);

}
