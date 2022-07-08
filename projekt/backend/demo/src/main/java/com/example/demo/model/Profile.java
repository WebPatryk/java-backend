package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="profile")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String password;
    private String email;

    public Profile() {
    }

    public Profile(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}