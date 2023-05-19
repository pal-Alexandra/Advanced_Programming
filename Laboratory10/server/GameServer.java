package org.compulsory.server;
/**
 * @author Pal Alexandra
 * This class creates a ServerSocket running at a specified port. The server receives requests (commands) from clients, and it executes them.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    public static final int PORT = 8100;
    public static boolean serverIsRunning = true;

    public GameServer() throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

            while (serverIsRunning) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                // Execute the client's requests in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }

    }

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }


}
