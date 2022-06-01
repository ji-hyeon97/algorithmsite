package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import com.dku.algorithmsite.dto.BoardDto;
import com.dku.algorithmsite.model.BoardEntity;
import com.dku.algorithmsite.repository.BoardRepository;
import com.dku.algorithmsite.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum, @AuthenticationPrincipal PrincipalDetail principal) {
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);
        model.addAttribute("principal",principal);
        if(principal != null) {
            model.addAttribute("boj_username", principal.getBoj_username());
        }

        return "index.html";
    }

    @PostMapping("/boardProc")
    public String boardProc(@RequestBody BoardEntity board){
        boardRepository.save(board);
        return "/index.html";
    }
}