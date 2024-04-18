package org.example.Component.Interface;

import com.sun.net.httpserver.HttpExchange;

public interface Crud {
    void list(HttpExchange exchange);

    void detail(HttpExchange exchange);

    void create(HttpExchange exchange);

    void patch(HttpExchange exchange);

    void put(HttpExchange exchange);

    void delete(HttpExchange exchange);
}
