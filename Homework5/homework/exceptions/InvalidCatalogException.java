package org.homework.exceptions;

/**
 * @author Pal Alexandra
 * This class is used to throw exceptions for invalid files paths, that should be storing a Catalog object.
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception exception) {

        super("Invalid catalog file.", exception);
    }

}
