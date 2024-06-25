package org.example.Controller;

import org.example.Component.Controller.CrudController;
import org.example.Component.DB.DB;
import org.example.Component.Model.Model;
import org.example.Component.Validator.Validator;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Profile;
import org.example.Model.User;

import java.util.Map;

public class UserController extends CrudController {
    @Override
    protected Class<? extends Model> getEntity() {
        return User.class;
    }

    public Response create(Request request) {
        Model record = request.deserialize(request.getBody(), this.getEntity(), DB.getLastId(this.getEntity()));
        User user = (User) record;
        Map<String, String> errors = Validator.validate(record);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.BAD_REQUEST);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.BAD_REQUEST);

        DB.create(record);
        Profile profile = new Profile();
        profile.setId(user.getId());
        profile.setFirstName(user.getFirstName());
        profile.setLastName(user.getLastName());
        profile.setEmail(user.getEmail());
        errors = Validator.validate(profile);
        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.BAD_REQUEST);
        DB.create(profile);

        return Response.json(request, record, HttpStatusCode.CREATED);
    }
}