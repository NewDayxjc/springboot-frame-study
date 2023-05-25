package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
//    @PreAuthorize("hasAnyRole('ADMIN')")
//    @GetMapping("/admin")
//    public String adminSuccess(){
//       return "admin-page";
//    }
//
//
//    @PreAuthorize("hasAnyRole('USER')")
//    @GetMapping("/user")
//    public String userSuccess(){
//        return "user-page";
//    }

    @PostMapping("/login")
    public String login(String username,String password){
        System.out.println(username+"------------"+password);
        return "login";
    }
}
