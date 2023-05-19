package org.homework.game;

/**
 * @author Pal Alexandra
 * This class describes a player of the TIC TAC TOE game.
 * This class is used as a wrapper for each Client (ClientThread) of a game
 */

import org.homework.ClientThread;

import java.util.Objects;

public class Player {
    private ClientThread client;
    private char symbol;

    public Player(ClientThread client) {
        this.client = client;
    }

    public ClientThread getClient() {
        return client;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setClient(ClientThread client) {
        this.client = client;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return symbol == player.symbol && Objects.equals(client, player.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, symbol);
    }
}
