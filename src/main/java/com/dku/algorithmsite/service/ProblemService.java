package com.dku.algorithmsite.service;

import com.dku.algorithmsite.model.Problem;
import com.dku.algorithmsite.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
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
    public int refreshProblem(int page_num){
        try {
            List<Problem> problems = new ArrayList<>();

            String CUR_URL = BOJ_PROBLEM_URL + page_num;
            Document document = Jsoup.connect(CUR_URL).userAgent("Mozilla").get();
            Elements problem_number = document.select(".hysUdN"); // 클래스를 이용해서 문제 번호 검색
            Elements problem_name = document.select(".__Latex__"); // 클래스를 이용해서 문제 이름 검색
            Elements tier_url = document.select("img[src$=.svg]"); // img태그의 src가 끝이 .svg끝나는 태그 검색

            for (int i = 0; i < tier_url.size(); i++) {
                Problem problem = Problem.builder()
                        .problem_number(Integer.parseInt(problem_number.get(i).text())) // 불필요한 태그를 제거하고 텍스트부분만 추출
                        .problem_name(problem_name.get(i).text()) // 불필요한 태그를 제거하고 텍스트부분만 추출
                        .tier_url(tier_url.get(i).attr("src")) // tier_url 객체의 src 옵션 정보를 가져옴.
                        .build();
                problems.add(problem);
            }
            problemRepository.saveAll(problems); // 100개씩 저장

            return HttpStatus.OK.value();
        }catch (IOException e){
            log.warn("ProblemService refreshAllProblem IOException");
            e.printStackTrace();

            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
    }

    @Transactional
    public int refreshAllProblem(){
        try {
            int page_num = 1;
            while (true) {
                List<Problem> problems = new ArrayList<>();

                String CUR_URL = BOJ_PROBLEM_URL + page_num;
                Document document = Jsoup.connect(CUR_URL).userAgent("Mozilla").get();
                Elements problem_number = document.select(".hysUdN"); // 클래스를 이용해서 문제 번호 검색
                Elements problem_name = document.select(".__Latex__"); // 클래스를 이용해서 문제 이름 검색
                Elements tier_url = document.select("img[src$=.svg]"); // img태그의 src가 끝이 .svg끝나는 태그 검색

                if (tier_url.size() == 0) break;
                for (int i = 0; i < tier_url.size(); i++) {
                    Problem problem = Problem.builder()
                            .problem_number(Integer.parseInt(problem_number.get(i).text())) // 불필요한 태그를 제거하고 텍스트부분만 추출
                            .problem_name(problem_name.get(i).text()) // 불필요한 태그를 제거하고 텍스트부분만 추출
                            .tier_url(tier_url.get(i).attr("src")) // tier_url 객체의 src 옵션 정보를 가져옴.
                            .build();
                    problems.add(problem);
                }
                problemRepository.saveAll(problems); // 100개씩 저장
                page_num++;
            }
            return HttpStatus.OK.value();
        }catch (IOException e){
            log.warn("ProblemService refreshAllProblem IOException");
            e.printStackTrace();
            return HttpStatus.INTERNAL_SERVER_ERROR.value();
        }
    }

    // entity 검증 메소드
    private void validate(final Problem entity){
        if(entity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }

        if(entity.getProblem_number() < 1000){
            log.warn("Unknown Problem.");
            throw new RuntimeException("Unknown Problem");
        }
    }
}
