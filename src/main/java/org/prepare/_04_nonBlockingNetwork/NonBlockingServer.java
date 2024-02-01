package org.prepare._04_nonBlockingNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class NonBlockingServer {
    private final int SEVER_PORT = 9999;
    public static void main(String[] args) {
        NonBlockingServer ns = new NonBlockingServer();
        ns.start();
    }

    private void start() {
        try(ServerSocket socket = new ServerSocket(SEVER_PORT);){
            while(true){
                Socket socket1 = socket.accept();
                Thread thread = new Thread(new NonBlockingServerThread(socket1));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private class NonBlockingServerThread implements Runnable {
        private final Socket socket;

        public NonBlockingServerThread(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try(BufferedReader bf
                        = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter response = new PrintWriter(socket.getOutputStream(), true)){
                System.out.println("Connected by : " + socket.getLocalAddress().getHostAddress() + "," + socket.getLocalPort());
                while(true){
                    String requestMessage = "";
                    String responseMessage = String.valueOf(Thread.currentThread().getId());
                    while((requestMessage = bf.readLine()) != null) {
                        System.out.println("recieved : "+ requestMessage);
                        TimeUnit.SECONDS.sleep(3);
                        if(requestMessage.equals("Ping")){
                            responseMessage += " : Pong";
                        } else {
                            responseMessage = " : Pong "+requestMessage;
                        }
                        response.println(responseMessage);
                        System.out.println("Send :" + responseMessage);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
