package com.dku.algorithmsite.controller.api;

import com.dku.algorithmsite.dto.ResponseDTO;
import com.dku.algorithmsite.service.ProblemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProblemApiController {

    private final ProblemService problemService;

    // 백준 문제를 100개 단위로 웹크롤링으로 갱신하는 메소드
    @GetMapping("/refresh/{page_num}")
    public ResponseDTO<Long> refresh(@PathVariable int page_num) throws IOException{
        int result = problemService.refreshProblem(page_num);
        log.info("boj_refresh status is {}.",result);
        return new ResponseDTO<Long>(result,null);
    }

    // 백준 문제를 웹크롤링으로 갱신하는 메소드
    @GetMapping("/refreshAll")
    public ResponseDTO<Long> refreshAll() throws IOException{
        int result = problemService.refreshAllProblem();
        log.info("boj_refreshAll status is {}.",result);
        return new ResponseDTO<Long>(result,null);
    }

}
