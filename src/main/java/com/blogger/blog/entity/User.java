package com.blogger.blog.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String username;
    private String Password;

    public User() {
        super();
    }

    public User(String username, String password) {
        this.username = username;
        Password = password;
    }
}
