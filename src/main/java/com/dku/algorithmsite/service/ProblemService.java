package com.dku.algorithmsite.service;

import com.dku.algorithmsite.model.Problem;
import com.dku.algorithmsite.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProblemService {

    private final ProblemRepository problemRepository;

    private static final String BOJ_PROBLEM_URL = "https://solved.ac/problems/all?page=";

    @Transactional
    public void refreshProblem() throws IOException {
        int page_num = 1;
        while(true) {
            List<Problem> problems = new ArrayList<>();

            String CUR_URL = BOJ_PROBLEM_URL + page_num;
            Document document = Jsoup.connect(CUR_URL).userAgent("Mozilla").get();
            Elements problem_number = document.select(".hysUdN");
            Elements problem_name = document.select(".__Latex__");
            Elements tier_url = document.select("img[src$=.svg]");

            if(tier_url.size() == 0) break;
            for (int i = 0; i < tier_url.size(); i++) {
                Problem problem = Problem.builder()
                        .problem_number(Integer.parseInt(problem_number.get(i).text()))
                        .problem_name(problem_name.get(i).text())
                        .tier_url(tier_url.get(i).attr("src"))
                        .build();
                problems.add(problem);
            }
            problemRepository.saveAll(problems);
            page_num++;
        }


        return ;
    }

    // entity 검증 메소드
    private void validate(final Problem entity){
        if(entity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }

        if(entity.getId() == null){
            log.warn("Unknown User.");
            throw new RuntimeException("Unknown User");
        }
    }
}
