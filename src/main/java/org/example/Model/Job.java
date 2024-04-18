package org.example.Model;

import org.example.Component.Model.Model;

public class Job extends Model {
    private String title;
    private String description;
    private double salary;

    public Job(String title, String description, double salary) {
        this.title = title;
        this.description = description;
        this.salary = salary;
    }

}
