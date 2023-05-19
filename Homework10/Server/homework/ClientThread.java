package org.homework;

/**
 * @author Pal Alexandra
 * This class will be responsible with communicating with a client.
 */

import org.homework.game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Game currentGame;

    private GameServer server;

    public ClientThread(GameServer server, Socket socket) {
        this.socket = socket;
        this.server = server;
    }

    /**
     * This method is responsible with communication between server and client.
     */
    public void run() {
        try {

            boolean stopClientThread = false;

            while (!stopClientThread) {

                // Get the requests from the input stream: client → server
                BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = inFromClient.readLine();

                // Send the response to the output stream: server → client
                System.out.println("[SERVER] Am primit de la client: " + request);
                PrintWriter outForClient = new PrintWriter(socket.getOutputStream());
                String answer;
                if (request.equals("stop")) {
                    stopClientThread = !stopClientThread;
                    server.removeClient(this);
                    answer = "Un client a iesit..";
                    outForClient.println(answer);
                    outForClient.flush();
                } else {
                    answer = "Server received the request: " + request + "!";
                    handleCommand(request);
                }

            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * This method returns the current game that the client is involved in.
     *
     * @return
     */
    public Game getCurrentGame() {
        return currentGame;
    }

    /**
     * This method sets the current game that the client is involved in.
     *
     * @param game
     */
    public void setCurrentGame(Game game) {
        currentGame = game;
    }

    /**
     * This method is handling the commands from the client.
     *
     * @param command
     * @throws IOException
     */
    public void handleCommand(String command) throws IOException {
        String[] tokens = command.split(" ");
        String keyword = tokens[0];

        switch (keyword) {
            case "create":
                server.createGame(this, tokens[2]);
                break;
            case "join":
                if (tokens.length >= 2) {
                    String gameName = tokens[2];
                    server.joinGame(this, gameName);
                } else {
                    sendMessage("Invalid join command. Usage: join <gameName>");
                }
                break;
            case "submit":
                if (tokens.length >= 3) {
                    int row = Integer.parseInt(tokens[2]);
                    int column = Integer.parseInt(tokens[3]);
                    server.submitMove(this, row, column);
                } else {
                    sendMessage("Invalid submit command. Usage: submit move <row> <column>");
                }
                break;
            default:
                sendMessage("Unknown command: " + command);
                break;
        }
    }

    /**
     * This method sends messages to the game client.
     *
     * @param message: the message to be sent
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        //System.out.println("SUNT IN SEND MESSAGE: vreau sa transmit: " + message);
        PrintWriter outForClient = new PrintWriter(socket.getOutputStream());
        outForClient.println("[Server received the request]Here is your answear: " + message);
        outForClient.flush();
    }

}



