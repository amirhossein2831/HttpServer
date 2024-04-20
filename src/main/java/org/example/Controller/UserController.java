package org.example.Controller;

import com.sun.net.httpserver.HttpExchange;
import org.example.Component.Controller.Controller;
import org.example.Component.Interface.Crud;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController extends Controller implements Crud {

    public void list(Request request) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alice", 25));
        userList.add(new User("Bob", 30));
        userList.add(new User("Charlie", 28));

        Response.json(request.getExchange(), userList, 200);
    }

    public void detail(Request request) {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");

        Response.json(request.getExchange(), data, 200);
    }

    public void create(Request request) {
    }

    @Override
    public void patch(Request request) {

    }

    @Override
    public void put(Request request) {

    }

    public void delete(Request request) {

    }

}