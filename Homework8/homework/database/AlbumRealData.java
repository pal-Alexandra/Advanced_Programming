package org.homework.database;
/**
 * @author Pal Alexandra
 * This class  imports a data from a real dataset (from https://www.kaggle.com/datasets/notgibs/500-greatest-albums-of-all-time-rolling-stone)
 * for the albums table
 */

import org.homework.DAOclasses.AlbumDAO;
import org.homework.objects.Album;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class AlbumRealData {

    private static final String realDataFile = "D:\\Ale\\Facultate\\An II sem II\\PA\\Lab8_TEMA\\albumlist.csv";

    /**
     * This method is used to read data from an external file and then insert the properties in the albums table.
     */
    public static void importData() {
        try (BufferedReader cin = new BufferedReader(new FileReader(realDataFile))) {
            String line;
            line = cin.readLine(); //first line are the name of the columns and I don't need them
            while ((line = cin.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                int releaseYear = Integer.parseInt(fields[1]);
                String title = fields[2];
                String artist = fields[3];
                String genre = fields[4];

                Album newAlbum = new Album(id, releaseYear, title, artist, genre);
                AlbumDAO.createAlbums(id, releaseYear, title, artist, genre);

                Database.getConnection().commit();

            }
        } catch (IOException | SQLException ex) {
            System.out.println("eroare in importData");
            System.out.println(ex);
        }

    }

}
