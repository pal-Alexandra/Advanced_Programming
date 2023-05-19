package org.compulsory.server;

/**
 * @author Pal Alexandra
 * This class is responsible with communicating with a client Socket.
 * If the server receives the command "stop" it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request "request_string" ".
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            boolean stopClientThread = false;
            BufferedReader inFromClient = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
            PrintWriter outForClient = new PrintWriter(socket.getOutputStream());

            while (!stopClientThread) {

                // Get the requests from the input stream: client → server
//                BufferedReader inFromClient = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
                String request = inFromClient.readLine();

                // Send the response to the output stream: server → client
                System.out.println("[SERVER-DEBUG] Am primit de la client: " + request);
//                PrintWriter outForClient = new PrintWriter(socket.getOutputStream());
                String answer;
                answer = "Server received the request: " + request + "!";
                if (request.equals("exit")) {
                    stopClientThread = !stopClientThread;
                    outForClient.println(answer);
                    outForClient.flush();
                } else if (request.equals("stop")) {
                    stopClientThread = !stopClientThread;
                    answer = "Server stopped..";
                    outForClient.println(answer);
                    outForClient.flush();

                    GameServer.serverIsRunning = false;
                    System.out.println("[SERVER-DEBUG] M-a oprit un client..");
                    System.exit(0);

                }else {
                    outForClient.println(answer);
                    outForClient.flush();
                }
            }
            inFromClient.close();
            outForClient.close();
            System.out.println("[SERVER-DEBUG] A iesit un client..");
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
//        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                System.err.println(e);
//            }
            try {
                socket.close();
            } catch (IOException exception) {
                System.err.println(exception);
            }

        }
    }

}
