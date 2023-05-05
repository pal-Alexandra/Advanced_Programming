package org.compulsory;

/**
 * @author Pal Alexandra
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.jdbc.ScriptRunner;

public class Main {
    /**
     * This method inserts entries in artists table and prints all the artists from database
     *
     * @param args
     */
    public static void main(String[] args) {
        try {

            deleteTables();
            createTables();
            insertArtists();
            printArtists();
            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
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
            throw new RuntimeException(e);
        }
    }

    /**
     * This method calls a PL/SQL script that deletes the tables.
     */
    public static void deleteTables(){
        ScriptRunner scriptRunner = new ScriptRunner(Database.getConnection());
        try {
            Reader reader = new BufferedReader(new FileReader("D:\\Ale\\Facultate\\An II sem II\\PA\\Lab8\\stergere_tabele.sql"));
            scriptRunner.setLogWriter(null);
            scriptRunner.runScript(reader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method inserts in the artists table some entries.
     */
    public static void insertArtists(){

        var artists = new ArtistDAO();
        try {
            artists.createArtist(1,"Pink Floyd");
            artists.createArtist(2,"Michael Jackson");
            artists.createArtist(3,"Queen");
            artists.createArtist(4,"Guns N'' Roses");
            artists.createArtist(5,"Katy Perry");

            Database.getConnection().commit();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method prints all the entries from artists table.
     */
    public static void printArtists(){
        try (Statement statement = Database.getConnection().createStatement();
             ResultSet artistSet = statement.executeQuery(
                     "select name from artists")) {

            while (artistSet.next()) {
                System.out.println(artistSet.getString(1));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }




}