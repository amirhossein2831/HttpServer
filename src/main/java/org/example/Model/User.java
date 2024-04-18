package org.example.Model;

import org.example.Component.Model.Model;

public class User extends Model {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
