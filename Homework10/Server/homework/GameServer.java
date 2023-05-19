package org.homework;

/**
 * @author Pal Alexandra
 * This class creates a ServerSocket, accepts clients, receives commands from them and executes the commands.
 */

import org.homework.game.Game;
import org.homework.game.Player;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    public static final int PORT = 8100;
    public static boolean serverIsRunning = true;

    private List<Game> games;
    private List<ClientThread> clients;

    /**
     * This is the constructor of the class.
     * Here the server accepts clients and creates a new thread for each of them.
     *
     * @throws IOException
     */
    public GameServer() throws IOException {

        ServerSocket serverSocket = null;
        clients = new ArrayList<>();
        games = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(PORT);

            while (serverIsRunning) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(this, socket);
                clients.add(clientThread);
                clientThread.start();
            }
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

    /**
     * This method creates a new game.
     *
     * @param client:   the client that sent the request for creating the game; also this client is by default the first player of it
     * @param gameName: the name of the game
     * @throws IOException
     */
    public void createGame(ClientThread client, String gameName) throws IOException {
        Game game = new Game(gameName);
        games.add(game);
        Player player = new Player(client);
        setPlayerSymbol(player, game);
        game.addPlayer(player);
        client.setCurrentGame(game);
        client.sendMessage("Game created. Your symbol is:" + player.getSymbol() + " Waiting for another player to join to the game with name: " + gameName);

    }

    /**
     * This method is setting the symbol of the player.
     *
     * @param player
     * @param game:  the game that the player is playing
     */
    public void setPlayerSymbol(Player player, Game game) {
        if (game.getPlayers().size() == 0) {
            player.setSymbol('X');
        } else {
            player.setSymbol('0');
        }
    }

    /**
     * This method add a new player to an existing game.
     *
     * @param client:   the client that sent the request to join the game.
     * @param gameName: the name of the game to join in
     * @throws IOException
     */



    public void joinGame(ClientThread client, String gameName) throws IOException {
        Game game = getGameByName(gameName);
        if (game != null) {
            Player player = new Player(client);
            setPlayerSymbol(player, game);
            game.addPlayer(player);
            client.setCurrentGame(game);
            client.sendMessage("Joined game: " + gameName + ". Waiting for the game to start. Your symbol is: " + player.getSymbol());
        } else {
            client.sendMessage("Game not found.");
        }
    }

    /**
     * This method is managing a move of a player. Also is printing on console the current state of the game.
     *
     * @param client: the client that sent the request
     * @param row:    the row of the board
     * @param column: the column of the boatd
     * @throws IOException
     */
    public void submitMove(ClientThread client, int row, int column) throws IOException {
        Game game = client.getCurrentGame();
        Player currentPlayer = game.getCurrentPlayer();
        if (game != null && !game.isOver(currentPlayer.getSymbol()) && game.isPlayerTurn(currentPlayer)) {
            boolean moveSuccessful = game.makeMove(client, row, column);
            if (moveSuccessful) {
                game.switchTurns();

                String message = "Move done";
                if (checkDraw(game)) {
                    message = drawMessage();
                } else if (checkHasWinner(game, currentPlayer)) {
                    message = hasWinnerMessage(game);

                }
                client.sendMessage(message);


                System.out.println("\n");
                System.out.println("****************************************************");
                System.out.println("****** THIS IS THE CURRENT STATE OF THE GAME: " + client.getCurrentGame().getGameName() + " ******");
                System.out.println(client.getCurrentGame().getBoard().toString());
                System.out.println("****************************************************");
                System.out.println("\n");

            } else {

                client.sendMessage("Invalid move. It's not your turn or you entered invalid positions. Please try again.");
            }
        } else {

            client.sendMessage("Invalid move. It's not your turn or there or the game is over.");
        }

    }

    /**
     * This method returns a proper message for a game that ended in draw.
     *
     * @return
     */
    public String drawMessage() {
        return "DRAW. THE GAME HAS NO WINNER. If you want to continue playing, create another game, or join an existing game";
    }

    /**
     * This method returns a message that contains the winner of the game from the parameter
     *
     * @param game
     * @return
     */
    public String hasWinnerMessage(Game game) {
        return "THE WINNER is the player " + game.getWinner().getSymbol() + ". If you want to continue playing, create another game, or join an existing game";

    }

    /**
     * This method checks if the game from the parameter is finished in draw.
     *
     * @param game
     * @return
     * @throws IOException
     */
    public boolean checkDraw(Game game) throws IOException {
        if (game.getBoard().isFull()) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if the current player won the game given in the parameter.
     *
     * @param game
     * @param currentPlayer
     * @return
     * @throws IOException
     */
    public boolean checkHasWinner(Game game, Player currentPlayer) throws IOException {
        if (game.getWinner() == null) {
            if (game.getBoard().hasWinner(currentPlayer.getSymbol())) {
                game.setWinner(currentPlayer);
                return true;
            } else {
                return false;
            }
        }
        return true;

    }

    /**
     * This method returns the game with the given name.
     *
     * @param gameName
     * @return
     */
    public Game getGameByName(String gameName) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                return game;
            }
        }
        return null;
    }

    /**
     * This method removes a client (and player) from the server (and his current game)
     *
     * @param clientThread
     */
    public void removeClient(ClientThread clientThread) {
        clients.remove(clientThread);
        Game game = clientThread.getCurrentGame();
        if (game != null) {
            game.removePlayer(clientThread);
            if (game.getPlayers().isEmpty()) {
                games.remove(game);
            }
        }


    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }
}
