package org.homework;

/**
 * This is the main class, and it is used to test the functionalities of the program.
 */

import org.apache.ibatis.jdbc.ScriptRunner;
import org.homework.DAOclasses.AlbumDAO;
import org.homework.DAOclasses.ArtistDAO;
import org.homework.DAOclasses.GenreDAO;
import org.homework.database.AlbumRealData;
import org.homework.database.Database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        deleteTables();
        createTables();

        insertArtists();
        testArtistsData();

        insertGenres();
        testGenresData();

        AlbumRealData.importData();
        testAlbumsData();

        try {
            Database.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method calls a PL/SQL script that creates the tables.
     */
    public static void createTables() {
        ScriptRunner scriptRunner = new ScriptRunner(Database.getConnection());
        try {
            Reader reader = new BufferedReader(new FileReader("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab8\\creare_tabele.sql"));
            scriptRunner.setLogWriter(null);
            scriptRunner.runScript(reader);
        } catch (FileNotFoundException e) {
            System.out.println("eroare in createTables");
            throw new RuntimeException(e);
        }
    }

    /**
     * This method calls a PL/SQL script that deletes the tables.
     */
    public static void deleteTables() {
        ScriptRunner scriptRunner = new ScriptRunner(Database.getConnection());
        try {
            Reader reader = new BufferedReader(new FileReader("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab8\\stergere_tabele.sql"));
            scriptRunner.setLogWriter(null);
            scriptRunner.runScript(reader);
        } catch (FileNotFoundException e) {
            System.out.println("eroare in deleteTables");
            throw new RuntimeException(e);
        }

    }

    /**
     * This method inserts in the artists table some entries.
     */
    public static void insertArtists() {

        var artists = new ArtistDAO();
        try {
            artists.createArtist(1, "Pink Floyd");
            artists.createArtist(2, "Michael Jackson");
            artists.createArtist(3, "Queen");
            artists.createArtist(4, "Guns N'' Roses");
            artists.createArtist(5, "Katy Perry");
            artists.createArtist(6, "Katy Perry");

            Database.getConnection().commit();
        } catch (SQLException e) {
            System.out.println("eroare in insertArtists");
            throw new RuntimeException(e);
        }
    }

    public static void testArtistsData() {

        var artists = new ArtistDAO();
        try {
            System.out.println("\n\n");
            artists.findByName("Katy Perry");
            artists.findById(4);
            artists.findAll();
        } catch (SQLException e) {
            System.out.println("eroare in printArtistsAfterName");
            throw new RuntimeException(e);
        }
    }

    /**
     * This method inserts in the genres table some entries.
     */
    public static void insertGenres() {
        var genres = new GenreDAO();
        try {
            genres.createGenre(1, "Rock");
            genres.createGenre(2, "Pop");
            genres.createGenre(3, "Folk");
            genres.createGenre(4, "Soul");
            genres.createGenre(5, "Country");

            Database.getConnection().commit();

        } catch (SQLException e) {
            System.out.println("eroare in insertGenres");
            throw new RuntimeException(e);
        }

    }

    public static void testGenresData() {
        var genres = new GenreDAO();
        try {
            System.out.println("\n\n");
            genres.findByName("Country");
            genres.findById(2);
            genres.findAll();
        } catch (SQLException e) {
            System.out.println("eroare in printAllGenres");
            throw new RuntimeException(e);
        }
    }

    public static void testAlbumsData() {
        var albums = new AlbumDAO();
        try {
            System.out.println("\n\n");
            albums.findById(63);
            albums.findByTitle("Songs in the Key of Life");
            //albums.findAll();
        } catch (SQLException e) {
            System.out.println("eroare in testAlbumData");
            throw new RuntimeException(e);
        }

    }


}