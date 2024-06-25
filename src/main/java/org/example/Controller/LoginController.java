package org.example.Controller;

import org.example.Component.Controller.Controller;
import org.example.Component.DB.DB;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.User;

import java.util.Map;

public class LoginController extends Controller {

    public static Response login(Request request) {
        Map<String, Object> body  = request.deserialize(request.getBody());
        User record = DB.getByColumnValue(User.class,"email",body.get("email"));
        if (record == null)
            return Response.json(request, Response.Error("record not found with this email: " + body.get("email")), HttpStatusCode.NOT_FOUND);

        if (!record.getPassword().equals(body.get("password")))
            return Response.json(request, Response.Error("password is incorrect" ), HttpStatusCode.BAD_REQUEST);

        //Token
        return Response.json(request,record);

    }


}
