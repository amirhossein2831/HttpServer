package org.example.Controller;

import com.sun.net.httpserver.HttpExchange;
import org.example.Component.Controller.Controller;
import org.example.Component.Interface.Crud;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Job;

import java.util.ArrayList;
import java.util.List;

public class JobController extends Controller implements Crud {

    @Override
    public void list(HttpExchange exchange) {
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job("Software Engineer", "Develop software applications", 80000));
        jobList.add(new Job("Data Scientist", "Analyze and interpret complex data", 90000));
        jobList.add(new Job("Marketing Manager", "Create marketing campaigns", 75000));

        Response.json(exchange, jobList, 200);
    }

    @Override
    public void detail(HttpExchange exchange) {

    }

    @Override
    public void create(HttpExchange exchange) {

    }

    @Override
    public void patch(HttpExchange exchange) {

    }

    @Override
    public void put(HttpExchange exchange) {

    }

    @Override
    public void delete(HttpExchange exchange) {

    }
}
