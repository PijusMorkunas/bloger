package com.blogger.blog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

   private String username;
   private String password;

   public LoginForm(){
       super();
   }



}
