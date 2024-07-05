package org.example.Controller;

import org.example.Component.Controller.CrudController;
import org.example.Component.DB.DB;
import org.example.Component.Model.Model;
import org.example.Component.Rule.AllFieldsRequire;
import org.example.Component.Validator.Validator;
import org.example.Http.HttpStatusCode;
import org.example.Http.Request;
import org.example.Http.Response;
import org.example.Model.Profile;
import org.example.Model.User;

import java.util.HashMap;
import java.util.Map;

public class ProfileController extends CrudController {

    @Override
    protected Class<? extends Model> getEntity() {
        return Profile.class;
    }

    public Response put(Request request, int id) {
        Model record = DB.get(this.getEntity(), id);
        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        Profile profile = (Profile) record;
        // Assuming request.getData() returns a Map with the JSON data
        Map<String, Object> requestData = request.deserializeToMap(request.getBody());

        // Update the profile with the request data
        if (requestData.containsKey("profilePhoto")) profile.setProfilePhoto((String) requestData.get("profilePhoto"));
        if (requestData.containsKey("bio")) profile.setBio((String) requestData.get("Bio"));
        if (requestData.containsKey("address")) profile.setAddress((String) requestData.get("address"));
        if (requestData.containsKey("link")) profile.setLink((String) requestData.get("link"));
        if (requestData.containsKey("backgroundPhoto")) profile.setBackgroundPhoto((String) requestData.get("backgroundPhoto"));
        if (requestData.containsKey("profession")) profile.setProfession((String) requestData.get("profession"));
        if (requestData.containsKey("company")) profile.setCompany((String) requestData.get("company"));
        if (requestData.containsKey("jobType")) profile.setJobType((String) requestData.get("jobType"));
        if (requestData.containsKey("jobState")) profile.setJobState((String) requestData.get("jobState"));
        if (requestData.containsKey("companyAddress")) profile.setCompanyAddress((String) requestData.get("companyAddress"));
        if (requestData.containsKey("startTime")) profile.setStartTime((String) requestData.get("startTime"));
        if (requestData.containsKey("endTime")) profile.setEndTime((String) requestData.get("endTime"));
        if (requestData.containsKey("phoneNumber")) profile.setPhoneNumber((String) requestData.get("phoneNumber"));
        if (requestData.containsKey("firstName")) profile.setFirstName((String) requestData.get("firstName"));
        if (requestData.containsKey("lastName")) profile.setLastName((String) requestData.get("lastName"));
        if (requestData.containsKey("additionalName")) profile.setAdditionalName((String) requestData.get("additionalName"));
        if (requestData.containsKey("email")) profile.setEmail((String) requestData.get("email"));
        if (requestData.containsKey("skills")) profile.setSkills((String) requestData.get("skills"));
        if (requestData.containsKey("location")) profile.setLocation((String) requestData.get("location"));

       // update model
        Map<String, String> errors = Validator.validate(profile);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.BAD_REQUEST);

        DB.update(profile);

        record = DB.get(User.class, id);
        User user = (User) record;
        if (record == null)
            return Response.json(request, Response.Error("record not found with id: " + id), HttpStatusCode.NOT_FOUND);

        if (requestData.containsKey("firstName")) user.setFirstName((String) requestData.get("firstName"));
        if (requestData.containsKey("lastName")) user.setLastName((String) requestData.get("lastName"));
        if (requestData.containsKey("email")) user.setEmail((String) requestData.get("email"));

        errors = Validator.validate(user);

        if (!errors.isEmpty())
            return Response.json(request, errors, HttpStatusCode.BAD_REQUEST);

        DB.update(user);
        return Response.json(request, profile, HttpStatusCode.OK);
    }
}
