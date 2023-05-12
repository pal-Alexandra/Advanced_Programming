package com.compulsory.laboratory9;

/**
 * @author Pal Alexandra
 * This class is used to illustrate the functionalities of compulsory tasks.
 */

import com.compulsory.laboratory9.entities.Artist;
import com.compulsory.laboratory9.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartRunner implements ApplicationRunner {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Artist> artistList = createArtists();
        System.out.println("Additional information: " + artistList.size());
        testArtistsData();
    }

    /**
     * This method creates artists objects and insert them as entries in the database.
     */
    public List<Artist> createArtists() {
        List<Artist> artists = new ArrayList<>();

        Artist artist = new Artist("Katty Perry");
        artistRepository.save(artist);
        artists.add(artist);

        Artist artist1 = new Artist("Dua Lipa");
        artistRepository.save(artist1);
        artists.add(artist1);

        Artist artist2 = new Artist("Madonna");
        artistRepository.save(artist2);
        artists.add(artist2);

        Artist artist3 = new Artist("Dua Lipa");
        artistRepository.save(artist3);
        artists.add(artist3);

        return artists;
    }

    /**
     * This method queries the database and writes the output in an external file.
     */
    public void testArtistsData() {
        System.out.println("Started");

        try {
            FileWriter cout = new FileWriter("output.txt");

            cout.write("\t\tAll artists from data base:\n");
            List<Artist> artistList = artistRepository.findAll();
            for (int i = 0; i < artistList.size(); i++) {
                cout.write(artistList.get(i).toString());
                cout.write("\n");
            }
            cout.write("\n");

            cout.write("\t\tInformation about the artist with the id 2:\n");
            cout.write(artistRepository.findById(2).toString());
            cout.write("\n");

            cout.write("\n");
            cout.write("\t\tInformation about the artists with the name Dua Lipa:\n");
            List<Artist> specificNameArtists = artistRepository.findByName("Dua Lipa");
            for (int i = 0; i < specificNameArtists.size(); i++) {
                cout.write(specificNameArtists.get(i).toString());
                cout.write("\n");
            }
            cout.write("\n");

            cout.close();

        } catch (IOException exception) {
            System.out.println(exception);
        }

    }
}