package com.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainController {

    @GetMapping("/train")
    public  String trainPage(){
        return "train";
    }
}
