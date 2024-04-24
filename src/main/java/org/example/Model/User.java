package org.example.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.example.Component.Model.Model;

@Entity
public class User extends Model {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String age;

    @Column @Email
    private String email;

    public User() {
    }

    public User(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
