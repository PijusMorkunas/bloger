package com.blogger.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
//    @RequestMapping("/user_login")
//    public String user_login(){
//        return "user_login";
//    }
//
//    @RequestMapping("/user_register")
//    public String user_register(){
//        return "user_register";
//    }
//
//}
//
//
//
