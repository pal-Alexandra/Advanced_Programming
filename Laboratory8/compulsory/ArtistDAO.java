package org.compulsory;
/**
 * @author Pal Alexandra
 * this class implements a DAO class that offer methods for managing artists
 */

import java.sql.*;

public class ArtistDAO {

    /**
     * This method inserts an artists into database
     *
     * @param id:   the value for the first column of artist's table
     * @param name: the value for the second column of artist's table
     * @throws SQLException
     */
    public void createArtist(int id, String name) throws SQLException {
        Connection connectionn = Database.getConnection();
        try (PreparedStatement prepareStatement = connectionn.prepareStatement(
                "insert into artists (id,name) values (?, ?)")) {
            //prepareStatement.setString(id, name);
            prepareStatement.setInt(1, id);
            prepareStatement.setString(2, name);
            prepareStatement.executeUpdate();
        }
    }

    /**
     * This method finds an artists by his name
     *
     * @param name
     * @return the id(s) for the artist(s) that has(ve) the name from the parameter
     * @throws SQLException
     */
    public Integer findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return resultSets.next() ? resultSets.getInt(1) : null;
        }
    }

    /**
     * This method finds an artists by his id
     *
     * @param id
     * @return the name(s) for the artist(s) that has(ve) the id from the parameter
     * @throws SQLException
     */
    public String findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(
                     "select name from artists where id='" + id + "'")) {
            return resultSets.next() ? resultSets.getString(1) : null;
        }
    }
}
