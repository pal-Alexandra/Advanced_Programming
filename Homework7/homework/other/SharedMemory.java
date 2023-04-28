package org.homework.other;

/**
 * @author Pal Alexandra
 * This class describes the shared memory that robots can acess.
 */

import org.homework.map.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class SharedMemory {

    private final List<Token> tokens;

    public SharedMemory(int n) {
        tokens = new ArrayList<>();
        for (int i = 1; i <= n * n * n; i++) {
            var token = new Token(i);
            tokens.add(token);
        }

        Collections.shuffle(this.tokens);
    }

    /**
     * This method is used to extract some random tokens from the shared memory.
     *
     * @param howMany: how many tokens will be extracted
     * @return the list of extracted tokens
     */
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(new Random().nextInt(tokens.size())));
        }
        return extracted;
    }
}
