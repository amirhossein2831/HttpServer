package org.example.Controller;

import org.example.Component.Controller.CrudController;
import org.example.Component.Model.Model;
import org.example.Model.User;

public class UserController extends CrudController {
    @Override
    protected Class<? extends Model> getEntity() {
        return User.class;
    }
}