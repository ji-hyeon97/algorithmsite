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
//        List<Problem> problemList = problemRepository.find(1);
//        model.addAttribute("problemList",problemList);
        System.out.println("principle: "+principal);
        model.addAttribute("principal",principal);
        return "/problem/problem";
    }

}
