package org.example.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.example.Component.Model.Model;

@Entity
public class Profile extends Model {
    @Id
    private Long id;


    @Column
    private String profilePhoto;

    @Column
    @Size(max = 220)
    private String Bio;

    @Column
    @Size(max = 220)
    private String address;

    @Column
    @Size(max = 220)
    private String link;

    @Column
    private String backgroundPhoto;

    @Column
    @Size(max = 60)
    private String profession;

    @Column
    @Size(max = 60)
    private String location;

    @Column
    @Size(max = 11)

    private String phoneNumber;

    @Column
    @Size(max = 20)
    private String firstName;

    @Column
    @Size(max = 40)
    private String lastName;

    @Column
    @Size(max = 40)
    private String additionalName;

    @Column
    @Email
    private String email;

    public Profile() {
    }

    public Profile(String profilePhoto, String bio, String address, String link, String backgroundPhoto, String profession, String location, String phoneNumber, String firstName, String lastName, String additionalName, String email) {
        this.profilePhoto = profilePhoto;
        Bio = bio;
        this.address = address;
        this.link = link;
        this.backgroundPhoto = backgroundPhoto;
        this.profession = profession;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.additionalName = additionalName;
        this.email = email;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public @Size(max = 220) String getBio() {
        return Bio;
    }

    public void setBio(@Size(max = 220) String bio) {
        Bio = bio;
    }

    public @Size(max = 220) String getAddress() {
        return address;
    }

    public void setAddress(@Size(max = 220) String address) {
        this.address = address;
    }

    public @Size(max = 220) String getLink() {
        return link;
    }

    public void setLink(@Size(max = 220) String link) {
        this.link = link;
    }

    public String getBackgroundPhoto() {
        return backgroundPhoto;
    }

    public void setBackgroundPhoto(String backgroundPhoto) {
        this.backgroundPhoto = backgroundPhoto;
    }

    public @Size(max = 60) String getProfession() {
        return profession;
    }

    public void setProfession(@Size(max = 60) String profession) {
        this.profession = profession;
    }

    public @Size(max = 60) String getLocation() {
        return location;
    }

    public void setLocation(@Size(max = 60) String location) {
        this.location = location;
    }

    public @Size(max = 11) String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Size(max = 11) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Size(max = 20) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Size(max = 20) String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 40) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 40) String lastName) {
        this.lastName = lastName;
    }

    public @Size(max = 40) String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(@Size(max = 40) String additionalName) {
        this.additionalName = additionalName;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }
}
