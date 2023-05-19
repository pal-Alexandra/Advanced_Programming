package org.compulsory.client;

/**
 * @author Pal Alexandra
 * This class will read commands from the keyboard, and it will send them to the server.
 */


import lombok.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class GameClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        boolean isRunning = true;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send requests to the server
            Scanner scanner = new Scanner(System.in);
            while (isRunning) {

                String request = scanner.nextLine();
                if (request.equals("stop") || (request.equals("exit"))) {
                    isRunning = false;
                    System.out.println("[CLIENT-DEBUG]: Intrerupem comunicarea..");
                }

                outToServer.println(request);

                // Wait the response from the server
                String response = inFromServer.readLine();
                System.out.println("[CLIENT-DEBUG]Am primit de la SERVER: " + response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
