package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContestController {

    @GetMapping("/contest")
    public String contest(Model model, @AuthenticationPrincipal PrincipalDetail principal){
        model.addAttribute("principal",principal);
        return "contest/contest";
    }

    @GetMapping("/contestForm")
    public String contestForm(Model model, @AuthenticationPrincipal PrincipalDetail principal){
        model.addAttribute("principal",principal);
        return "contest/contestForm";
    }
}
