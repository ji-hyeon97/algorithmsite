package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import com.dku.algorithmsite.dto.ContestDto;
import com.dku.algorithmsite.dto.ContestMakeDTO;
import com.dku.algorithmsite.dto.ContestProblemDTO;
import com.dku.algorithmsite.service.ContestService;
import com.dku.algorithmsite.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContestController {
    private final ContestService contestService;
    private final UserService userService;

    @GetMapping("/contest")
    public String contest(Model model, @AuthenticationPrincipal PrincipalDetail principal){
        List<ContestDto> contestList = contestService.getContestList();

        model.addAttribute("contestList",contestList);
        model.addAttribute("principal",principal);
        if(principal != null) {
            model.addAttribute("boj_username", principal.getBoj_username());
        }
        return "contest/contest";
    }

    @GetMapping("/contestForm")
    public String contestForm(Model model, @AuthenticationPrincipal PrincipalDetail principal){
        model.addAttribute("principal",principal);
        if(principal != null)
            model.addAttribute("boj_username",principal.getBoj_username());

        return "contest/contestForm";
    }

    @PostMapping("/contestForm/makeForm")
    public String contestFormMake(@RequestBody ContestMakeDTO contestInfo){
        if(contestService.contestMake(contestInfo))
            return "contest/contest";
        else
            return "error/errorPage";
    }

    @GetMapping("/contestDetail/{id}")
    public String detail(@PathVariable String id, Model model) {
        Long contest_id = Long.parseLong(id);
        ContestDto contestDto = contestService.getById(contest_id);
        List<ContestProblemDTO> problems = contestService.getProblemsByContest_id(contest_id);
        List<String> bojs = userService.findAllBoj();
        model.addAttribute("contest",contestDto);
        model.addAttribute("problems",problems);
        model.addAttribute("bojs",bojs);
        return "contest/contestDetail";
    }
}
