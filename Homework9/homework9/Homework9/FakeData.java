package com.homework9.Homework9;

import com.github.javafaker.Faker;
import com.homework9.Homework9.entities.Album;
import com.homework9.Homework9.entities.Artist;
import com.homework9.Homework9.entities.Genre;

/**
 * @author Pal Alexandra
 * This class is used to generate a large number of fake artists and albums.
 */

import java.util.*;

public class FakeData {


    private final Faker faker;

    public FakeData() {
        this.faker = new Faker();
    }

    public List<Artist> generateArtists(long howMany) {
        List<Artist> artists = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            Artist artist = new Artist();
            artist.setName((faker.artist().name()));
            artists.add(artist);
        }
        return artists;
    }

    public List<Genre> genrateGenres(long howMany) {
        List<Genre> genres = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            Genre genre = new Genre();
            genre.setName((faker.music().genre()));
            genres.add(genre);
        }
        return genres;
    }

    public Set<Album> generateAlbums(List<Artist> artists, List<Genre> genres, long howMany) {
        Set<Album> albums = new HashSet<>();
        for (int i = 0; i < howMany; i++) {
            Album album = new Album();
            StringBuilder albumName = new StringBuilder();
            albumName.append("Album_");
            albumName.append(i);
            album.setName(albumName.toString());
            album.setReleaseYear(faker.number().numberBetween(1940, 2023));
            Random random = new Random();
            int nr = random.nextInt(artists.size() - 1);
            album.setArtist(artists.get(nr));
            Set<Genre> albumGenres = new HashSet<>();
            for (int j = 0; j < faker.number().numberBetween(1, 5); j++) {
                albumGenres.add(genres.get(faker.number().numberBetween(0, genres.size() - 1)));
            }
            album.setGenres(albumGenres);
            albums.add(album);
        }
        return albums;
    }
}
