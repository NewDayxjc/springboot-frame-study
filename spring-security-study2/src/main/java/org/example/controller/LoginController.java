package org.example.controller;

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
    public String login(String userAccount,String userPwd){
        System.out.println(userAccount+"------------"+userPwd);
        return "login";
    }
}
