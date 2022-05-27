package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import com.dku.algorithmsite.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemRepository problemRepository;

    @GetMapping("/problem")
    public String problemList(Model model, @AuthenticationPrincipal PrincipalDetail principal){
        model.addAttribute("principal",principal);
        if(principal != null)
            model.addAttribute("boj_username",principal.getBoj_username());

        return "/problem/problem";
    }

}
