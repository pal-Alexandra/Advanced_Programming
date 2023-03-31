package org.homework.commands;

/**
 * @author Pal Alexandra
 * This class describe the command save from the Document Management System
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import org.homework.system.Catalog;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    /**
     * This is the constructor of the class
     *
     * @param command: sets the name of the command
     * @param catalog: sets the Catalog object that will be processed
     */
    public SaveCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    /**
     * This method is used to save the catalog to an external file using JSON format
     *
     * @param catalog: the Catalog object that will be processed
     * @param path:    the path for the saving file, in the local file system
     */
    public static void save(Catalog catalog, String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(path + catalog.getName() + ".json"), catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
