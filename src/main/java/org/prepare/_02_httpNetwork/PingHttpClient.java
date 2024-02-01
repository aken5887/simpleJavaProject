package org.prepare._02_httpNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PingHttpClient {
    public static void main(String[] args) {
        PingHttpClient httpClient = new PingHttpClient();
        httpClient.connect();
    }

    private void connect(){
        final int PORT = 5678;
        final String IP = "127.0.0.1";

        try(Socket socket = new Socket(IP, PORT);
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){

            System.out.println("IP : "+IP+" has connected ");
            while(true){
                Scanner scan = new Scanner(System.in);
                String request = scan.nextLine();
                out.println(request);
                System.out.println("request : "+request);
                System.out.println("response : " + bf.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
