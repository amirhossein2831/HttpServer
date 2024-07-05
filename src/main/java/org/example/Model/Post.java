package org.example.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.example.Component.Model.Model;

@Entity
public class Post extends Model {
    @Id
    private Long id;

    @Column
    private String userId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String photo;

    public Post() {

    }

    public Post(Long id, String userId, String title, String description, String photo) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.photo = photo;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}