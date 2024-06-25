package org.example.Controller;

import org.example.Component.Controller.CrudController;
import org.example.Component.Model.Model;
import org.example.Model.Profile;

public class ProfileController extends CrudController {

    @Override
    protected Class<? extends Model> getEntity() {
        return Profile.class;
    }
}
