package org.homework.game;

/**
 * @author Pal Alexandra
 * This class describes and manages the logic of the TIC TAC TOE game.
 */

import org.homework.ClientThread;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final String gameName;
    private final Board board;
    private Player currentPlayer;

    private Player winner;

    private List<Player> players;

    public Game(String gameName) {
        this.gameName = gameName;
        this.board = new Board();
        players = new ArrayList<>();
        this.currentPlayer = null;
        this.winner = null;
    }

    public String getGameName() {
        return gameName;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isPlayerTurn(Player player) {
        return currentPlayer == player;
    }

    public boolean isOver(char symbol) {
        return board.isFull() || board.hasWinner(symbol);
    }

    public boolean isValidMove(int line, int column) {
        return board.isValidMove(line, column);
    }

    public boolean makeMove(ClientThread client, int row, int column) {

        Player player = getPlayerByClient(client);

        if (player != null && player == currentPlayer && isValidMove(row, column)) {
            char symbol = player.getSymbol();
            board.makeMove(row, column, symbol);
            return true;
        }
        return false;

    }

    /**
     * This class returns the player corresponding to the received ClientThread
     *
     * @param client
     * @return
     */
    private Player getPlayerByClient(ClientThread client) {
        for (Player player : players) {
            if (player.getClient() == client) {
                return player;
            }
        }
        return null;
    }

    public void switchTurns() {
        if (currentPlayer == players.get(0)) {
            currentPlayer = players.get(1);
        } else {
            currentPlayer = players.get(0);
        }
    }

    public void addPlayer(Player player) {
        if (players.size() < 2) {
            players.add(player);
            if (players.size() == 2) {
                currentPlayer = players.get(0);
            }
        }
    }

    public void removePlayer(ClientThread clientThread) {
        for (Player player : players) {
            if (player.getClient() == clientThread) {
                players.remove(player);
                break;
            }
        }

        if (players.size() < 2) {
            currentPlayer = null;
        }

    }

    public void setWinner(Player player) {
        winner = player;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }


}
