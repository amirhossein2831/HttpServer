package org.example.Component.Interface;

import com.sun.net.httpserver.HttpExchange;
import org.example.Http.Request;
import org.example.Http.Response;

public interface Crud {
    Response list(Request request);

    Response detail(Request request, int id);

    Response create(Request request);

    Response patch(Request request, int id);

    Response put(Request request, int id);

    Response delete(Request request, int id);
}
