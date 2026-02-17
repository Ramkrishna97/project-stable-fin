package com.example.finstability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    @PostMapping("/save")
    public void takeData(){
        //POST method that takes data from web , save
        System.out.println();
    }
    @GetMapping("/getData")
    public void showData(){
        // GET method to show list of data
    }
}
