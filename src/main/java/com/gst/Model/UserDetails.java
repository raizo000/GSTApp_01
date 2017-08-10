package com.gst.Model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userDetails_id")
    private int userDetails_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "toiec")
    private String toiec;
    @Column(name = "experience")
    private String experience;
    @Column(name = "location")
    private String location;
    @Column(name = "program_language")
    private String program_language;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "education")
    private String education;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "active")
    private int active;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getUser_id() {
        return userDetails_id;
    }

    public void setUser_id(int user_id) {
        this.userDetails_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getToiec() {
        return toiec;
    }

    public void setToiec(String toiec) {
        this.toiec = toiec;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProgram_language() {
        return program_language;
    }

    public void setProgram_language(String program_language) {
        this.program_language = program_language;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserDetails_id() {
        return userDetails_id;
    }

    public void setUserDetails_id(int userDetails_id) {
        this.userDetails_id = userDetails_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
