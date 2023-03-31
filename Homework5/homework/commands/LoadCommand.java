package org.homework.commands;


/**
 * @author Pal Alexandra
 * This class describe the command load from the Document Management System
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.homework.exceptions.InvalidCatalogException;
import org.homework.system.Catalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {
    /**
     * This is the constructor of the class
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public LoadCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    /**
     * This method is used to load a Catalog object from an external file.
     *
     * @param path: the path for the external file, in the local file system
     * @throws InvalidCatalogException: this exception is for invalid files paths, that should be storing a Catalog object
     * @throws IOException
     * @return: the loaded Catalog object
     */
    public static Catalog load(String path) throws InvalidCatalogException, IOException {
        Catalog catalog = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
