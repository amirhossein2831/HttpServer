package org.example.Controller;

import com.sun.net.httpserver.HttpExchange;
import org.example.Component.Controller.Controller;
import org.example.Component.Interface.Crud;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Job;

import java.util.ArrayList;
import java.util.List;

public class JobController extends Controller implements Crud {

    @Override
    public void list(Request request) {
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job("Software Engineer", "Develop software applications", 80000));
        jobList.add(new Job("Data Scientist", "Analyze and interpret complex data", 90000));
        jobList.add(new Job("Marketing Manager", "Create marketing campaigns", 75000));

        Response.json(request, jobList, HttpStatusCode.OK);
    }

    @Override
    public void detail(Request request,int id) {

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
