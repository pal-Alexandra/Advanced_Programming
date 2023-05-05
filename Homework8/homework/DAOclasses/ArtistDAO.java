package org.homework.DAOclasses;
/**
 * @author Pal Alexandra
 * This class implements the DAO class for the artists table
 */

import org.homework.database.Database;
import org.homework.objects.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAO {

    /**
     * This method inserts a new entry in the artists table
     *
     * @param id:  value for the first column
     * @param name : value for the second column
     * @throws SQLException
     */
    public void createArtist(int id, String name) throws SQLException {
        Connection connectionn = Database.getConnection();
        Artist newArtist = new Artist(id, name);
        try (PreparedStatement prepareStatement = connectionn.prepareStatement(
                "insert into artists (id,name) values (?, ?)")) {
            prepareStatement.setInt(1, newArtist.getId());
            prepareStatement.setString(2, newArtist.getName());
            prepareStatement.executeUpdate();
        }
    }

    /**
     * This method selects the entries from the artists table that have the name from the parameter
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Artist> findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet artistSet = statement.executeQuery(
                     "select * from artists where name='" + name + "'")) {
            System.out.println("\nInformation about all artists with name: " + name);
            List<Artist> artistsResults = new ArrayList<>();
            while (artistSet.next()) {
                Artist newArtist = new Artist(artistSet.getInt(1), artistSet.getString(2));
                System.out.println(newArtist.toString());
                artistsResults.add(newArtist);
            }
            return artistsResults;
        }
    }

    /**
     * This method selects the entries from the artists table that have the id from the parameter
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Artist> findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet artistSet = statement.executeQuery(
                     "select * from artists where id='" + id + "'")) {

            System.out.println("\nInformation about all artists with id: " + id);
            List<Artist> artistsResults = new ArrayList<>();
            while (artistSet.next()) {
                Artist newArtist = new Artist(artistSet.getInt(1), artistSet.getString(2));
                System.out.println(newArtist.toString());
                artistsResults.add(newArtist);
            }
            return artistsResults;
        }
    }

    /**
     * This method selects all the entries from the artists table
     *
     * @return
     * @throws SQLException
     */
    public List<Artist> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet artistSet = statement.executeQuery(
                     "select * from artists")) {

            System.out.println("\nInformation about all artists: ");
            List<Artist> artistsResults = new ArrayList<>();
            while (artistSet.next()) {
                Artist newArtist = new Artist(artistSet.getInt(1), artistSet.getString(2));
                System.out.println(newArtist.toString());
                artistsResults.add(newArtist);
            }
            return artistsResults;
        }
    }


}
