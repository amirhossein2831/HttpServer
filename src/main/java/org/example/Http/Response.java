package org.example.Http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Response {

    public static void json(HttpExchange exchange, Object res, int status) {
        Gson gson = new GsonBuilder().create();
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        try {
            exchange.sendResponseHeaders(status, 0);

            OutputStream outputStream = exchange.getResponseBody();
            String json = gson.toJson(res);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void send(HttpExchange exchange, String res) {
        exchange.getResponseHeaders().set("Content-Type", "text/html");
        try {
            exchange.sendResponseHeaders(200, res.length());
            OutputStream os = exchange.getResponseBody();
            os.write(res.getBytes());
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
