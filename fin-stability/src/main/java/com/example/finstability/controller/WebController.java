package com.example.finstability.controller;

import com.example.finstability.service.StableFin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {

    @Autowired
    public StableFin fin;

}
