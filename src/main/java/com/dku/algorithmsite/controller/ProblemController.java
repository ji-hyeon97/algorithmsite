package com.dku.algorithmsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProblemController {

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/hello")
    public String indexPage(){
        return "hello";
    }
}
