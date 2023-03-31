package org.compulsory;

/**
 * @author Pal Alexandra
 * This class describe a custom exception.
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception exception) {
        super("Invalid catalog file.", exception);
    }

}
