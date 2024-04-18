package org.example.Http;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.Component.Controller.Controller;
import org.example.Component.Interface.Crud;
import org.example.Route.Route;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {
    private static HTTPServer instance;
    private HttpServer server;

    public static HTTPServer getInstance() {
        if (instance == null) {
            instance = new HTTPServer();
        }
        return instance;
    }

    // create server
    public void createServer(int port, int executorNumber) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(executorNumber);

        server = HttpServer.create(new InetSocketAddress(port), 0);
        Route.route(instance);
        server.setExecutor(executor);

        server.start();
        System.out.println("Server started on port " + port);
    }

  
}
