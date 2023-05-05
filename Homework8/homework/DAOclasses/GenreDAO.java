package org.homework.DAOclasses;
/**
 * @author Pal Alexandra
 * This class implements the DAO class for the genres table
 */

import org.homework.database.Database;
import org.homework.objects.Genre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {

    /**
     * This method inserts a new entry in the genress table
     *
     * @param id:   value for the first column
     * @param name: value for the second column
     * @throws SQLException
     */
    public void createGenre(int id, String name) throws SQLException {
        Connection connectionn = Database.getConnection();
        Genre newGenre = new Genre(id, name);
        try (PreparedStatement prepareStatement = connectionn.prepareStatement(
                "insert into genres (id,name) values (?, ?)")) {
            prepareStatement.setInt(1, newGenre.getId());
            prepareStatement.setString(2, newGenre.getName());
            prepareStatement.executeUpdate();
        }
    }

    /**
     * This method selects the entries from the genres table that have the name from the parameter
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Genre> findByName(String name) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet genresSet = statement.executeQuery(
                     "select * from genres where name='" + name + "'")) {
            System.out.println("\nInformation about all genres with name: " + name);
            List<Genre> genresResult = new ArrayList<>();
            while (genresSet.next()) {
                Genre newGenre = new Genre(genresSet.getInt(1), genresSet.getString(2));
                System.out.println(newGenre.toString());
                genresResult.add(newGenre);
            }
            return genresResult;
        }
    }

    /**
     * This method selects the entries from the genress table that have the id from the parameter
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<Genre> findById(int id) throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet genreSet = statement.executeQuery(
                     "select * from genres where id='" + id + "'")) {

            System.out.println("\nInformation about all genres with id: " + id);
            List<Genre> genresResult = new ArrayList<>();
            while (genreSet.next()) {
                Genre newGenre = new Genre(genreSet.getInt(1), genreSet.getString(2));
                System.out.println(newGenre.toString());
                genresResult.add(newGenre);
            }
            return genresResult;
        }
    }

    /**
     * This method selects all the entries from the genres table
     *
     * @return
     * @throws SQLException
     */
    public List<Genre> findAll() throws SQLException {
        Connection connection = Database.getConnection();
        try (Statement statement = connection.createStatement();
             ResultSet genreSet = statement.executeQuery(
                     "select * from genres")) {

            System.out.println("\nInformation about all genres: ");
            List<Genre> genresResult = new ArrayList<>();
            while (genreSet.next()) {
                Genre newGenre = new Genre(genreSet.getInt(1), genreSet.getString(2));
                System.out.println(newGenre.toString());
                genresResult.add(newGenre);
            }
            return genresResult;
        }
    }
}
