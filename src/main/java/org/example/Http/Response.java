package org.example.Http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {


    public static void json(Request request, Object res, int status) {
        Gson gson = new GsonBuilder().create();
        request.getExchange().getResponseHeaders().set("Content-Type", "application/json");
        try {
            request.getExchange().sendResponseHeaders(status, 0);

            OutputStream outputStream = request.getExchange().getResponseBody();
            String json = gson.toJson(res);
            outputStream.write(json.getBytes());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void json(Request request, Object res) {
        json(request, res, 200);
    }

    public static void send(Request request, String res, int status) {
        request.getExchange().getResponseHeaders().set("Content-Type", "text/html");
        try {
            request.getExchange().sendResponseHeaders(status, res.length());
            OutputStream os = request.getExchange().getResponseBody();
            os.write(res.getBytes());
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void send(Request request, String res) {
        send(request, res, 200);
    }


    public static void render(Request request, String filePath, int status) {
        filePath = "src/main/resources/templates/" + filePath;
        Path path = Paths.get(filePath);
        request.getExchange().getResponseHeaders().set("Content-Type", "text/html");
        try {
            String res = Files.readString(path);
            request.getExchange().sendResponseHeaders(status, res.length());
            OutputStream os = request.getExchange().getResponseBody();
            os.write(res.getBytes());
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void render(Request request, String filePath) {
        render(request, filePath, 200);
    }

}
