package org.example.Controller;

import org.example.Component.Controller.Controller;
import org.example.Http.Request;
import org.example.Http.Response;

public class HomeController extends Controller {
    public static void handleHome(Request request) {
        Response.render(request.getExchange(), "index.html");
    }
}
