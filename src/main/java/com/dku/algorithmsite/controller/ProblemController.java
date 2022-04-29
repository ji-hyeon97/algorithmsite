package com.dku.algorithmsite.controller;

import com.dku.algorithmsite.dto.ResponseDTO;
import com.dku.algorithmsite.service.ProblemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProblemController {

    private final ProblemService problemService;

    // 백준 문제를 웹크롤링으로 갱신하는 메소드
    @GetMapping("/refresh")
    public ResponseDTO<Long> refresh(){
        try{
            problemService.refreshProblem();
        }catch (IOException e){
            log.warn("ProblemController refresh method IOException.");
            e.printStackTrace();
        }
        return new ResponseDTO<Long>(HttpStatus.OK.value(),null);
    }

}
