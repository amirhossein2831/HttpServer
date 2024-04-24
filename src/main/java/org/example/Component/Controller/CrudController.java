package org.example.Component.Controller;

import com.google.gson.Gson;
import org.example.Component.DB.DB;
import org.example.Component.Interface.Crud;
import org.example.Component.Model.Model;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Job;
import org.example.Model.User;

import java.util.HashMap;
import java.util.List;

public abstract class CrudController extends Controller implements Crud {

    protected abstract Class<? extends Model> getEntity();

    public void list(Request request) {
        List<? extends Model> records = DB.all(this.getEntity());

        Response.json(request, records, HttpStatusCode.OK);
    }

    public void detail(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);

        if (record != null)
            Response.json(request, record, HttpStatusCode.OK);
        else
            Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);
    }

    public void create(Request request) {

    }



    public void patch(Request request, int id) {

    }

    public void put(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record != null) {
            Model updatedRecord = deserializeRequest(request.getBody(),this.getEntity());

            updatedRecord.setId((long) id);

            DB.update(updatedRecord);

            Response.json(request, updatedRecord, HttpStatusCode.OK);
        } else
            Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);
    }

    public void delete(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record != null) {
            DB.delete(record);
            Response.json(request, new HashMap<>(), HttpStatusCode.NO_CONTENT);
        } else
            Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);
    }

    private Model deserializeRequest(String json, Class<? extends Model> clazz) {
        return new Gson().fromJson(json, clazz);
    }
}
