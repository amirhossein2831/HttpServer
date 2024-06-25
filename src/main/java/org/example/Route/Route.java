package org.example.Route;

import org.example.Controller.*;
import org.example.Http.HTTPServer;
import org.example.Model.Profile;

public class Route {

    public static void route(HTTPServer server) {
        // customer route and handler
        server.get("/", HomeController::handleHome);
        server.get("/home", HomeController::handleHome);
        server.post("/login", LoginController::login);

        // crud route
        server.routeCrud("/users", new UserController());
        server.routeCrud("/jobs", new JobController());
        server.routeCrud("/profile", new ProfileController());
    }
}
