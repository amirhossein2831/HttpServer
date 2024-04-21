package org.example.Controller;

import org.example.Component.Controller.Controller;
import org.example.Component.DB.DB;
import org.example.Component.Interface.Crud;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.User;

import java.util.List;

public class UserController extends Controller implements Crud {

    @Override
    public void list(Request request) {
        List<User> users = DB.all(User.class);

        Response.json(request, users, HttpStatusCode.OK);
    }

    @Override
    public void detail(Request request, int id) {
        User user = DB.get(User.class, id);

        if (user != null)
            Response.json(request, user, HttpStatusCode.OK);
        else
            Response.json(request, Response.Error("record now found with id: " + id), HttpStatusCode.NOT_FOUND);
    }

    @Override
    public void create(Request request) {

    }

    @Override
    public void patch(Request request, int id) {

    }

    @Override
    public void put(Request request, int id) {

    }

    @Override
    public void delete(Request request, int id) {

    }

}