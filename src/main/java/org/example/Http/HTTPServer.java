package org.example.Http;

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

    // handle crud and set the request
    public void routeCrud(String name, Crud controller) {
        server.createContext(name, exchange -> {
            Controller c = (Controller) controller;
            c.setRequest(new Request(exchange));
            String method = exchange.getRequestMethod();

            switch (method) {
                case "GET" -> {
                    if (c.getRequest().getParam() == null) {
                        controller.list(exchange);
                    } else if (c.getRequest().getParam().matches("\\d+")) {
                        controller.detail(exchange);
                    }
                }
                case "POST" -> controller.create(exchange);
                case "PUT" -> controller.put(exchange);
                case "PATCH" -> controller.patch(exchange);
                case "DELETE" -> controller.delete(exchange);
            }
        });
    }

  
}
