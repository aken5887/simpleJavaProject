package org.practice.programmers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.http.HttpClient;

/**
 * # API Server 구성
 * > 김그렙은 신규 고객서비스를 위한 API Server 개발을 요청받았습니다.
 *
 * ## 유의사항
 *
 * 응시자는 아래의 요구사항에 맞는 응답을 처리하기 위한 API 서버를 완성해야 합니다. `채점하기` 버튼을 누르면 응시자가 구성한 서버로 요청을 보내 채점을 진행합니다. 각 문항별 `요청(Request)`은 채점코드가 요청하는 내용을 의미하고 `응답(Response)`는 응시자가 구현한 서버에서 응답하는 내용을 의미합니다. 지문에 있는 요청 예시 및 응답 예시는 실제 채점 케이스와는 다릅니다.
 *
 * -   별도의 언급이 없는 경우, API 서버의 모든 정상 응답은 상태 코드 `200`을 포함하여 전송합니다.
 * -   모든 응답 메시지의 body는 JSON 형식이며, 응답 메시지의 헤더에는 `Content-Type`을 `application/json`으로 설정합니다.
 * -   주소는 모든 IP에서 접근할 수 있도록 `0.0.0.0`으로 실행하고 포트는 `5678`을 사용합니다.
 *     - `localhost` 혹은 `127.0.0.1`로 서버가 실행되거나 `5678`이외의 포트를 사용한다면 채점이 이루어지지 않습니다.
 *
 *
 * ## 문제
 *
 * ### 요청 사항 1. HTTP Request / Response
 *
 * ---
 *
 * 클라이언트가 요청을 보내면 서버는 그 요청 메세지를 해석한 다음 적절한 결과물을 응답 메세지로 작성해 돌려줘야 합니다. API 서버에서 요청이 성공적으로 처리되는지 확인하는 기능을 만들어 주세요.
 *
 * ### ✅ 구현 조건
 *
 * -   API 서버로 보내지는 요청 형식은 다음과 같습니다.
 *     -   URL : `0.0.0.0:5678`
 *     -   method : `GET`
 * -   정상 요청이 들어온 경우 아래와 같이 응답합니다.
 *     -   `{"message":"server check"}`
 *
 * ### ✅ 요청 예시
 *
 * ```bash
 * curl -X GET 0.0.0.0:5678 \
 * -H 'Content-Type: application/json'
 * ```
 *
 * ### ✅ 응답 예시
 *
 * ```json
 * {
 *     "message": "server check"
 * }
 * ```
 *
 * ### 요청 사항 2. 유저 데이터 확인
 *
 * ---
 *
 * 클라이언트가 요청을 보내면 파일에 저장되어 있는 유저들의 정보를 확인하여 응답해야 합니다. 주어진 파일을 읽어서 유저들의 게시물 갯수(`post_count`)의 총합을 응답하는 기능을 구현해 주세요.
 *
 * ### ✅ 구현 조건
 *
 * -   API 서버로 보내지는 요청 형식은 다음과 같습니다.
 *     -   URL : `0.0.0.0:5678/sum`
 *     -   method : `GET`
 * -   정상 요청이 들어온 경우 파일에 있는 각 유저들의 `post_count`값을 모두 더하여 아래와 같이 응답합니다.
 *     -   `{"sum": 유저들의 post_count의 총합}`
 *
 * ### ✅ 요청 예시
 *
 * ```bash
 * curl -X GET 0.0.0.0:5678/sum \
 * -H 'Content-Type: application/json'
 * ```
 *
 * ### ✅ 응답 예시
 *
 * ```json
 * {
 *     "sum": 256
 * }
 * ```
 */
public class _5_practice {
    private static final int port = 5678;

    public static void main(String[] args) throws IOException {
        connect();
    }
    static void connect() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler());
        server.createContext("/sum", new MyHandler2());
        server.setExecutor(null);
        server.start();
        System.out.println("Server has started on port = "+port);
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "{\"message\" : \"server check\"}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class MyHandler2 implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String filePath = "/Users/choi/Workspace/simpleJavaProject/user.json";
            ObjectMapper objectMapper = new ObjectMapper();
            int sum = 0;
            User[] users = objectMapper.readValue(new File(filePath), User[].class);
            for(User user:users){
                System.out.println(user.getPost_count());
                sum+=user.getPost_count();
            }

            String response = "{\"sum\":" + sum + "}";
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class User {
        private long id;
        private String name;
        private int post_count;
        private String job;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPost_count() {
            return post_count;
        }

        public void setPost_count(int post_count) {
            this.post_count = post_count;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }
    }
}
