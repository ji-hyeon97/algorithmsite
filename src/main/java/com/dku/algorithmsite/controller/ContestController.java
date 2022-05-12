package com.dku.algorithmsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContestController {

    @GetMapping("/contest")
    public String contest(){
        return "contest/Contest";
    }

}
