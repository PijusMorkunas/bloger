package com.blogger.blog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    //model class holds singup data

    private String username;
    private String password;


//no arg constructor/constructor with no parameters, !needs more research!

    public RegisterForm() {
        super();
    }

    public RegisterForm(String username, String password) {
        //why do i need super here?
        super();
        this.username = username;
        this.password = password;
    }
}
