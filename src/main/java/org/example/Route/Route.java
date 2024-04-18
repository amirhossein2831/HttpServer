package org.example.Route;

import org.example.Controller.HomeController;
import org.example.Controller.JobController;
import org.example.Controller.UserController;
import org.example.Http.HTTPServer;

public class Route {

    public static void route(HTTPServer server) {
        // crud route
        server.routeCrud("/users", new UserController());
        server.routeCrud("/jobs", new JobController());

        // customer route and handler
        server.get("/home", HomeController::handleHome);
    }
}
