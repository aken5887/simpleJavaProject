package org.prepare._04_nonBlockingNetwork;

import org.checkerframework.checker.units.qual.N;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NonBlockingClient {
    public static void main(String[] args) {
        NonBlockingClient nc = new NonBlockingClient();
        nc.connect();
    }

    private void connect(){
        while(true){
            Scanner scan = new Scanner(System.in);
            String messaage = scan.nextLine();
            Thread myThread = new Thread(new NonBlockingClientThread(messaage));
            myThread.start();
        }
    }

    private class NonBlockingClientThread implements Runnable {
        private final int SERVER_PORT = 5678;
        private final String SERVER_IP = "127.0.0.1";

        private final String message;

        public NonBlockingClientThread(String message) {
            this.message = message;
        }

        @Override
        public void run() {

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println(Thread.currentThread().getId()+" : "+message);
            System.out.println("Send :"+message);
            String response = "";
            while ((response = bf.readLine()) != null) {
                System.out.println("Received : "+ response);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
}
