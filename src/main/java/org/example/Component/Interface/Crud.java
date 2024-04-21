package org.example.Component.Interface;

import com.sun.net.httpserver.HttpExchange;
import org.example.Http.Request;

public interface Crud {
    void list(Request request);

    void detail(Request request, int id);

    void create(Request request);

    void patch(Request request, int id);

    void put(Request request, int id);

    void delete(Request request, int id);
}
