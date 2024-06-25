package org.example.Http;

import com.sun.net.httpserver.HttpServer;
import org.example.Component.Controller.Controller;
import org.example.Component.Interface.Crud;
import org.example.Component.Interface.RequestHandler;
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
            Request request = new Request(exchange);

            switch (request.getMethod()) {
                case "GET" -> {
                    if (request.getParam() == null) {
                        controller.list(request);
                    } else if (request.getParam().matches("\\d+")) {
                        controller.detail(request,Integer.parseInt(request.getParam()));
                    }
                }
                case "POST" -> controller.create(request);
                case "PUT" -> controller.put(request, Integer.parseInt(request.getParam()));
                case "PATCH" -> controller.patch(request, Integer.parseInt(request.getParam()));
                case "DELETE" -> controller.delete(request, Integer.parseInt(request.getParam()));
            }
        });
    }

    // need to handle the request inside the custom method
    public void get(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            String method = exchange.getRequestMethod();
            if (method.equals("GET")) {
                handler.handle(new Request(exchange));
            }
        });
    }

    // need to handle the request inside the custom method
    public void show(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            Request request = new Request(exchange);
            String method = exchange.getRequestMethod();
            if (method.equals("GET")) {
                if (request.getParam().matches("\\d+")) {
                    handler.handle(request);
                }
            }
        });
    }

    public void post(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            String method = exchange.getRequestMethod();
            if (method.equals("POST")) {
                handler.handle(new Request(exchange));
            }
        });
    }

    public void put(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            String method = exchange.getRequestMethod();
            if (method.equals("PUT")) {
                handler.handle(new Request(exchange));
            }
        });
    }

    public void patch(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            String method = exchange.getRequestMethod();
            if (method.equals("PATCH")) {
                handler.handle(new Request(exchange));
            }
        });
    }

    public void delete(String name, RequestHandler handler) {
        server.createContext(name, exchange -> {
            String method = exchange.getRequestMethod();
            if (method.equals("DELETE")) {
                handler.handle(new Request(exchange));
            }
        });
    }

}
