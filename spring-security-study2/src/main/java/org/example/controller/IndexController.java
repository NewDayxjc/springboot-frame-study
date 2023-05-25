package org.example.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class IndexController {


//        @GetMapping("/index")
//
//        public String index(){
//                return "success";
//        }

        @GetMapping("/index")
        public String login(){
                return "login.html";
        }

        @GetMapping("/findAll")
        @Secured({"role_admin"})
        @PreAuthorize("hasRole('role_admin')")
        @ResponseBody
        public String findAll(){
                return "findAll";
        }


        @GetMapping("/find")
        @ResponseBody
        public String find(){
                return "find";
        }
        @GetMapping("/unauth")

        public String unauth(){
                return "unauth.html";
        }
}
