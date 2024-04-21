package org.example.Controller;

import com.sun.net.httpserver.HttpExchange;
import jakarta.persistence.Entity;
import org.example.Component.Controller.Controller;
import org.example.Component.DB.DB;
import org.example.Component.Interface.Crud;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController extends Controller implements Crud {

    public void list(Request request) {
        List<User> users = DB.all(User.class);

        Response.json(request, users, HttpStatusCode.OK);
    }

    public void detail(Request request, int id) {
        try {
            User user = DB.get(User.class, id);
            Response.json(request, user, HttpStatusCode.OK);
        } catch (NullPointerException e) {
            Response.json(request, Response.Error("record not found"), HttpStatusCode.NOT_FOUND);
        }
    }

    public void create(Request request) {
    }

    @Override
    public void patch(Request request, int id) {

    }

    @Override
    public void put(Request request, int id) {

    }

    public void delete(Request request, int id) {

    }

}