package org.homework.DAOclasses;
/**
 * @author Pal Alexandra
 * This class implements the DAO class for the albums table
 */

import org.homework.database.Database;
import org.homework.objects.Album;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    /**
     * This method inserts a new entry in the albums table
     *
     * @param id:          value for the first column
     * @param releaseYear: value for the second column
     * @param title:       value for the third column
     * @param artist:      value for the forth column
     * @param genre:       value for the fifth column
     * @throws SQLException
     */
    public static void createAlbums(int id, int releaseYear, String title, String artist, String genre) throws SQLException {
        Connection connectionn = Database.getConnection();
        Album newAlbum = new Album(id, releaseYear, title, artist, genre);
        try (PreparedStatement prepareStatement = connectionn.prepareStatement(
                "insert into albums (id,release_year,title,artist,genre) values (?, ?, ?, ?, ?)")) {
            prepareStatement.setInt(1, newAlbum.getId());
            prepareStatement.setInt(2, newAlbum.getReleaseYear());
            prepareStatement.setString(3, newAlbum.getTitle());
            prepareStatement.setString(4, newAlbum.getArtist());
            prepareStatement.setString(5, newAlbum.getGenre());
            prepareStatement.executeUpdate();
        }
    }

    /**
     * This method selects the entries from the albums table that have the title from the parameter
     *
     * @param title
     * @return
     * @throws SQLException
     */
    public List<Album> findByTitle(String title) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet albumsSet = statement.executeQuery(
                     "select * from albums where title='" + title + "'")) {
            System.out.println("\nInformation about all albums with title: " + title);
            List<Album> albumsResults = new ArrayList<>();
            while (albumsSet.next()) {
                Album newAlbum = new Album(albumsSet.getInt(1), albumsSet.getInt(2),
                        albumsSet.getString(3), albumsSet.getString(4), albumsSet.getString(5));
                System.out.println(newAlbum.toString());
                albumsResults.add(newAlbum);
            }
            return albumsResults;
        }
    }


    /**
     * This method selects the entries from the albums table that have the id from the parameter
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Album> findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet albumsSet = statement.executeQuery(
                     "select * from albums where id='" + id + "'")) {

            System.out.println("\nInformation about all albums with id: " + id);
            List<Album> albumsResults = new ArrayList<>();
            while (albumsSet.next()) {
                Album newAlbum = new Album(albumsSet.getInt(1), albumsSet.getInt(2),
                        albumsSet.getString(3), albumsSet.getString(4), albumsSet.getString(5));
                System.out.println(newAlbum.toString());
                albumsResults.add(newAlbum);
            }
            return albumsResults;
        }
    }


    /**
     * This method selects all the entries from the albums table
     *
     * @return
     * @throws SQLException
     */
    public List<Album> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet albumsSet = statement.executeQuery(
                     "select * from albums")) {

            System.out.println("\nInformation about all albums: ");
            List<Album> albumsResults = new ArrayList<>();
            while (albumsSet.next()) {
                Album newAlbum = new Album(albumsSet.getInt(1), albumsSet.getInt(2),
                        albumsSet.getString(3), albumsSet.getString(4), albumsSet.getString(5));
                System.out.println(newAlbum.toString());
                albumsResults.add(newAlbum);
            }
            return albumsResults;
        }
    }
}
