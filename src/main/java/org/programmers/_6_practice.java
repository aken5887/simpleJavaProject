package org.programmers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class _6_practice {
    private static final int port = 5678;
    public static void main( String[] args )
    {
        connect();
    }

    static void connect() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on : "+port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("accepted coneection form client : "+ clientSocket.getInetAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static void handleClient(Socket socket){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             OutputStream out = socket.getOutputStream();) {
            String requestLine = reader.readLine();
            String path = extractPath(requestLine);

            if("/".equals(path)){
                myHandler1(out);
            }else if("/sum".equals(path)){
                myHandler2(out);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void myHandler1(OutputStream out) throws IOException {
        String response = "{\"message\":\"server check\"}";
        sendResponse(out, response);
    }

    private static void myHandler2(OutputStream out) throws IOException {
        int sum = 0;
        File file = new File("/Users/choi/Workspace/simpleJavaProject/user2.json");
        ObjectMapper objectMapper = new ObjectMapper();
        User[] users = objectMapper.readValue(file, User[].class);
        for(User user:users){
            sum += user.getPost_count();
        }
        String response = "{\"sum\":"+sum+"}";
        sendResponse(out, response);
    }

    private static String extractPath(String requestLine){
        String[] parts = requestLine.split(" ");
        if(parts.length >= 2){
            return parts[1];
        }
        return "/";
    }

    private static void sendResponse(OutputStream outputStream, String response) throws IOException {
        // 응답 헤더 설정
        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain; charset=utf-8\r\n" +
                "Content-Length: " + response.length() + "\r\n" +
                "\r\n" +
                response;

        // 응답 본문 전송
        outputStream.write(httpResponse.getBytes());
        outputStream.flush();
    }

    static class User {
        private long id;
        private int post_count;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getPost_count() {
            return post_count;
        }

        public void setPost_count(int post_count) {
            this.post_count = post_count;
        }
    }
}