package org.example.Route;

import org.example.Controller.HomeController;
import org.example.Controller.JobController;
import org.example.Controller.UserController;
import org.example.Http.HTTPServer;

public class Route {

    public static void route(HTTPServer server) {
        // customer route and handler
        server.get("/", HomeController::handleHome);
        server.get("/home", HomeController::handleHome);

        // crud route
        server.routeCrud("/users", new UserController());
        server.routeCrud("/jobs", new JobController());
    }
}
