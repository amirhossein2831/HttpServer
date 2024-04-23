package org.example.Controller;

import org.example.Component.Controller.CrudController;
import org.example.Component.Model.Model;
import org.example.Model.Job;

public class JobController extends CrudController{
    @Override
    protected Class<? extends Model> getEntity() {
        return Job.class;
    }
}
