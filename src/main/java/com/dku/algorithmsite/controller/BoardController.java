package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.dto.BoardDto;
import com.dku.algorithmsite.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList", boardList);
        return "index.html";
    }
}