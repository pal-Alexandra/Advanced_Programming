package org.homework.map;

/**
 * @author Pal Alexandra
 * This class describes the token (represented by a number) from the shared memory.
 */

public class Token {
    private final int number;

    public Token(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}
