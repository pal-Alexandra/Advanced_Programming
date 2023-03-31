package org.compulsory;


import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;

/**
 * @author Pal Alexandra
 * This class is responsible with external operations regarding a catalog.
 */
public class CatalogUtil {

    /**
     * This method saves a catalog to an external file using JSON format.
     *
     * @param catalog: the catalog to be saved
     * @param path:    the path of the external file.
     * @throws IOException: if the output file is not valid, an exception will be thrown.
     */
    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    /**
     * This method loads a catalog from an external file.
     *
     * @param path: the path of the external file
     * @throws InvalidCatalogException: if the input file is not valid, a custom exception will be thrown.
     * @throws IOException:             if the input file is not valid, an exception will be thrown.
     * @return: the loaded catalog
     */
    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(path),
                Catalog.class
        );
    }

}
