package org.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.example.Component.Model.Model;

@Entity
public class Job extends Model {
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Double salary;

    public Job() {

    }

    public Job(String title, String description, Double salary) {
        this.title = title;
        this.description = description;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
