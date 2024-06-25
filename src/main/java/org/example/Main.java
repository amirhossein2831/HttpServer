package org.example;

import org.example.Component.DB.DB;
import org.example.Http.HTTPServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HTTPServer server = HTTPServer.getInstance();
        DB.initDb();

        server.createServer(8001,10);
    }
}