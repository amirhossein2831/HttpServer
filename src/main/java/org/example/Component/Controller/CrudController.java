package org.example.Component.Controller;

import org.example.Component.DB.DB;
import org.example.Component.Interface.Crud;
import org.example.Component.Model.Model;
import org.example.Component.Rule.AllFieldsRequire;
import org.example.Component.Validator.Validator;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CrudController extends Controller implements Crud {

    protected abstract Class<? extends Model> getEntity();

    public Response list(Request request) {
        List<? extends Model> records = DB.all(this.getEntity());

        return Response.json(request, records, HttpStatusCode.OK);
    }

    public Response detail(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        return Response.json(request, record, HttpStatusCode.OK);
    }

    public Response create(Request request) {
        Model record = request.deserialize(request.getBody(), this.getEntity(), DB.getLastId(this.getEntity()));
        Map<String, String> errors = Validator.validate(record);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.CREATED);

        DB.create(record);
        return Response.json(request, record, HttpStatusCode.CREATED);
    }

    public Response patch(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        Map<String, Object> body = request.deserialize(request.getBody());
        Model.update(record, body);

        Map<String, String> errors = Validator.validate(record);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.CREATED);

        DB.update(record);
        return Response.json(request, record, HttpStatusCode.OK);
    }

    public Response put(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        Model updatedRecord = request.deserialize(request.getBody(), this.getEntity(), (long) id);
        if (!AllFieldsRequire.check(updatedRecord))
            return Response.json(request, Response.Error("All Field are required" + id), HttpStatusCode.NOT_FOUND);

        Map<String, String> errors = Validator.validate(updatedRecord);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.CREATED);

        DB.update(updatedRecord);
        return Response.json(request, updatedRecord, HttpStatusCode.OK);
    }

    public Response delete(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);

        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        DB.delete(record);
        return Response.json(request, new HashMap<>(), HttpStatusCode.NO_CONTENT);
    }
}
