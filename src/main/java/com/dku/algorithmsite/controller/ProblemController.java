package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.model.Problem;
import com.dku.algorithmsite.repository.ProblemRepository;
import com.dku.algorithmsite.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemRepository problemRepository;

    @GetMapping("/problem")
    public String problemList(Model model){
        List<Problem> problemList = problemRepository.find(1);
        model.addAttribute("problemList",problemList);
        return "problem";
    }

}
