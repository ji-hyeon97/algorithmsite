package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/auth/login")
    public String loginPage(){
        return "/auth/loginForm";
    }

    @GetMapping("/auth/signup")
    public String signUpPage(){
        return "/auth/signupForm";
    }
}
