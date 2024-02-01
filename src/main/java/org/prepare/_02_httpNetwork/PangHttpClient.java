package org.prepare._02_httpNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PangHttpClient {
    private final int PORT = 5678;
    private final String IP =  "127.0.0.1";
    public static void main(String[] args) {
        PangHttpClient httpClient = new PangHttpClient();
        httpClient.connect();
    }

    private void connect() {
        try(Socket socket = new Socket(IP, PORT);
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ){

            System.out.println("IP : "+IP+" has connected ");
            while(true){
                Scanner scanner = new Scanner(System.in);
                String send = scanner.nextLine();
                out.println(send);
                System.out.printf("send : %s", send);
                System.out.println();
                String response = bf.readLine();
                System.out.printf("response : %s", response);
                System.out.println();
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
