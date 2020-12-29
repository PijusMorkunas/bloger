package com.blogger.blog.Controller;

import com.blogger.blog.model.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value="/user_login", method = RequestMethod.GET)
    public String getLoginForm(){
        return "user_login";
    }
    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public String user_login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model){

        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if("admin".equals(username) && "admin".equals(password)){
            //if true return home
            return "home";
        }
        //if false return home
        model.addAttribute("invalidCredentials", true);
        return "home";

    }




}
