package com.homework9.Homework9;
/**
 * @author Pal Alexandra
 * This class is used to illustrate the functionalities of homework.
 */

import com.homework9.Homework9.entities.Album;
import com.homework9.Homework9.entities.Artist;
import com.homework9.Homework9.entities.Genre;
import com.homework9.Homework9.repositories.AlbumRepository;
import com.homework9.Homework9.repositories.ArtistRepository;
import com.homework9.Homework9.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

@Component
public class StartRunner implements ApplicationRunner {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FakeData fakeData = new FakeData();

        int countEntries = 100;

        List<Artist> artistList = createArtists(fakeData, countEntries);

        List<Genre> genreList = createGenres(fakeData, countEntries);
        Set<Album> albumList = createAlbums(artistList, genreList, fakeData, countEntries);

        testGenreData();

        Random random = new Random();
        Artist randomArtist = artistList.get(random.nextInt(countEntries));
        testArtistsData(randomArtist.getName());

        testAlbumData();


        try {
            Thread.sleep(120000);
        } catch (Exception e) {

        }

    }

    public List<Artist> createArtists(FakeData fakeData, int countEntries) {
        List<Artist> artistList = fakeData.generateArtists(countEntries);
        artistRepository.saveAll(artistList);
        return artistList;
    }

    public List<Genre> createGenres(FakeData fakeData, int countEntries) {
        List<Genre> genreList = fakeData.genrateGenres(countEntries);
        genreRepository.saveAll(genreList);
        return genreList;
    }

    public Set<Album> createAlbums(List<Artist> artists, List<Genre> genres, FakeData fakeData, int countEntries) {
        Set<Album> albumList = fakeData.generateAlbums(artists, genres, countEntries);
        albumRepository.saveAll(albumList);
        return albumList;
    }

    /**
     * This method queries the artists9 table from database, then writes the result in an external file and logs the execution time of JPQL statements in an external file.
     *
     * @param specificName: used to find the artists with that name
     */
    public void testArtistsData(String specificName) {

        try {
            BufferedWriter informationWriter = new BufferedWriter(new FileWriter("information.txt", true));
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("logs.txt", true));

            informationWriter.write("\n\n");
            logWriter.write("\n\n");

            long start = System.currentTimeMillis();
            System.out.println("DEBUG1");
            List<Artist> artists = artistRepository.findAll();
            long end = System.currentTimeMillis();
            long timeElapsed = end - start;
            logWriter.write("\tExecution time for finding all artists: " + timeElapsed + " miliseconds\n");
            informationWriter.write("\t\tAll artists from database are: \n");
            for (Artist artist : artists) {
                informationWriter.write(artist.toString() + "\n");
            }

            start = System.currentTimeMillis();
            List<Artist> specificNameArtists = artistRepository.findByName(specificName);
            end = System.currentTimeMillis();
            timeElapsed = end - start;
            logWriter.write("\tExecution time for finding all artists with name: " + specificName + " is: " + timeElapsed + " miliseconds\n");
            informationWriter.write("\t\tAll artists from database are with name: " + specificName + "\n");
            for (Artist artist : specificNameArtists) {
                informationWriter.write(artist.toString() + "\n");
            }

            informationWriter.close();
            logWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method queries the album9 table from database, then writes the result in an external file and logs the execution time of JPQL statements in an external file.
     */
    public void testAlbumData() {
        try {
            BufferedWriter informationWriter = new BufferedWriter(new FileWriter("information.txt", true));
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("logs.txt", true));

            informationWriter.write("\n\n");
            logWriter.write("\n\n");

            long start = System.currentTimeMillis();
            List<Album> randomAlbums = albumRepository.findAll();
            Album randomAlbum = randomAlbums.get(4);
            Optional<Album> specificAlbum = albumRepository.findById(randomAlbum.getId());
            long end = System.currentTimeMillis();
            long timeElapsed = end - start;
            logWriter.write("\tExecution time for finding the album with id= " + randomAlbum.getId() + ": " + timeElapsed + " miliseconds\n");

            informationWriter.write("\t\tThe album with id " + randomAlbum.getId() + ": \n");
            informationWriter.write(specificAlbum.toString() + "\n");

            informationWriter.close();
            logWriter.close();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * This method queries the genres9 table from database, then writes the result in an external file and logs the execution time of JPQL statements in an external file.
     */
    public void testGenreData() {
        try {

            BufferedWriter informationWriter = new BufferedWriter(new FileWriter("information.txt"));
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("logs.txt"));

            long start = System.currentTimeMillis();
            List<Genre> genres = genreRepository.findAll();
            long end = System.currentTimeMillis();
            long timeElapsed = end - start;
            logWriter.write("\tExecution time for finding all genres from database: " + timeElapsed + " miliseconds\n");

            informationWriter.write("\t\tAll genres from database are: \n");
            for (Genre genre : genres) {
                informationWriter.write(genre.toString());
                informationWriter.write("\n");
            }

            start = System.currentTimeMillis();
            Optional<Genre> specificGenre = genreRepository.findById(genres.get(5).getId());
            end = System.currentTimeMillis();
            timeElapsed = end - start;
            logWriter.write("\tExecution time for finding the genre with the id " + genres.get(5).getId() + ": " + timeElapsed + " miliseconds\n");

            informationWriter.write("\t\tInformation about the genre with the id " + genres.get(5).getId() + " :\n");
            informationWriter.write(specificGenre.toString());

            start = System.currentTimeMillis();
            List<Genre> otherSpecificGenres = genreRepository.findByName(genres.get(3).getName());
            end = System.currentTimeMillis();
            timeElapsed = end - start;
            logWriter.write("\tExecution time for finding the genre(s) with the name " + genres.get(3).getName() + ": " + timeElapsed + " miliseconds\n");

            informationWriter.write("\n\t\tInformation about the genre(s) with the name " + genres.get(3).getName() + " :\n");
            for (Genre genre : otherSpecificGenres) {
                informationWriter.write(genre.toString() + "\n");
            }

            informationWriter.close();
            logWriter.close();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
