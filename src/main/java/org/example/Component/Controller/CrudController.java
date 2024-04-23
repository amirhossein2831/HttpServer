package org.example.Component.Controller;

import org.example.Component.DB.DB;
import org.example.Component.Model.Model;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Job;

import java.util.List;

public abstract class Controller {

   protected abstract <T extends Model>  Class<T> getEntity();

    public void list(Request request) {
        List<?> records = DB.all(this.getEntity());

        Response.json(request, records, HttpStatusCode.OK);
    }

    public void detail(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);

        if (record != null)
            Response.json(request, record, HttpStatusCode.OK);
        else
            Response.json(request, Response.Error("record now found with id: " + id), HttpStatusCode.NOT_FOUND);
    }

    public void create(Request request) {

    }

    public void patch(Request request, int id) {

    }

    public void put(Request request, int id) {

    }

    public void delete(Request request, int id) {
    }
}
