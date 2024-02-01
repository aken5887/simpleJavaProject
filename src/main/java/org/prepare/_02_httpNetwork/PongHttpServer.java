package org.prepare._02_httpNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PongHttpServer {
    private final int PORT = 5678;

    public static void main(String[] args) {
        PongHttpServer httpServer = new PongHttpServer();
        httpServer.start();
    }

    private void start() {
        try(ServerSocket serverSocket = new ServerSocket(PORT);){
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from client");
                Thread thread = new Thread(new PongServerThread(clientSocket));
                thread.start();
            }
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }

    private class PongServerThread implements Runnable {
        private final Socket clientSocket;

        public PongServerThread(Socket socket){
            this.clientSocket = socket;
        }
        @Override
        public void run() {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);){
                System.out.println("Connected by : " + clientSocket.getLocalAddress().getHostAddress() + "," + clientSocket.getLocalPort());

                String receivedMessage = "";
                while ((receivedMessage = bf.readLine()) != null) {
                    System.out.println("Received : " + receivedMessage);
                    if ("Ping".equals(receivedMessage)) {
                        out.println("Pong");
                        System.out.println("Send : Pong");
                    } else {
                        String res = new StringBuilder(receivedMessage).reverse().toString();
                        out.println(res);
                        System.out.println("Send : " + res);
                    }
                }
            } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
        }
    }
}
