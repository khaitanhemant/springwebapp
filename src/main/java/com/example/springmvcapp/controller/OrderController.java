package com.example.springmvcapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/")
    String entry()
    {
        return "Welcome to my first spring Web App!!";
    }
}
