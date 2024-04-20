package org.example.Component.Interface;

import com.sun.net.httpserver.HttpExchange;
import org.example.Http.Request;

public interface Crud {
    void list(Request request);

    void detail(Request request);

    void create(Request request);

    void patch(Request request);

    void put(Request request);

    void delete(Request request);
}
