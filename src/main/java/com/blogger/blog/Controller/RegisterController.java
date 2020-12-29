package com.blogger.blog.Controller;

import com.blogger.blog.Repository.UserRepository;
import com.blogger.blog.entity.User;
import com.blogger.blog.model.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    //Autowire user repo
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user_register")
    public String getRegister() {
        return "/user_register";
    }

    @PostMapping("/user_register")
    public String submitRegister(RegisterForm registerForm) {


        //checking if the form data is coming
        User user = null;
        if (null != registerForm) {
            user = new User(registerForm.getUsername(), registerForm.getPassword());
        }
        userRepository.save(user);
        return "register_success";
    }


}
