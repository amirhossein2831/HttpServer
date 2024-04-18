package org.example;

import org.example.Http.HTTPServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HTTPServer server = HTTPServer.getInstance();

        server.createServer(8000,10);
    }
}