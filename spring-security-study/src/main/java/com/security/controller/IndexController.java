package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        @ResponseBody
        public String findAll(){
                return "findAll";
        }


        @GetMapping("/find")
        @ResponseBody
        public String find(){
                return "find";
        }
}
