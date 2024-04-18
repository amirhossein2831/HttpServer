package org.example.Controller;

import com.sun.net.httpserver.HttpExchange;
import org.example.Component.Controller.Controller;
import org.example.Http.Response;

public class HomeController extends Controller {
    public static void handleHome(HttpExchange exchange) {
        Response.render(exchange, "index.html");
    }
}
