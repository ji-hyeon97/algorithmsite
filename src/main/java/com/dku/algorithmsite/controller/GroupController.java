package com.dku.algorithmsite.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class GroupController {

    @GetMapping("/group")
    public String group(){
        return "group/TeamInformation";
    }
}
