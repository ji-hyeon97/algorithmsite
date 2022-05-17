package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import com.dku.algorithmsite.dto.TeamDto;
import com.dku.algorithmsite.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TeamController {

    private TeamService teamService;

    @GetMapping("/team")
    public String group(Model model,  @AuthenticationPrincipal PrincipalDetail principal){
        List<TeamDto> teamList = teamService.getTeamList();
        model.addAttribute("teamList", teamList);
        model.addAttribute("principal",principal);
        return "group/TeamInformation";
    }
}
