package com.dku.algorithmsite.service;

import com.dku.algorithmsite.dto.ContestDto;
import com.dku.algorithmsite.dto.ContestMakeDTO;
import com.dku.algorithmsite.dto.ContestProblemDTO;
import com.dku.algorithmsite.model.Contest;
import com.dku.algorithmsite.model.Contest_Problem;
import com.dku.algorithmsite.repository.ContestProblemRepository;
import com.dku.algorithmsite.repository.ContestRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContestService {
    private final ContestRepository contestRepository;
    private final ContestProblemRepository contestProblemRepository;

    public void savePost(ContestDto contestDto) {
        contestRepository.save(contestDto.toEntity());
    }

    @Transactional
    public List<ContestDto> getContestList() {
        List<Contest> contestEntities = contestRepository.findAll();
        List<ContestDto> contestDtoList = new ArrayList<>();

        for (Contest contestEntity : contestEntities) {
            ContestDto contestDTO = ContestDto.builder()
                    .id(contestEntity.getId())
                    .contest_name(contestEntity.getContest_name())
                    .contest_description(contestEntity.getContest_description())
                    .startTime(contestEntity.getStartTime())
                    .endTime(contestEntity.getEndTime())
                    .build();

            contestDtoList.add(contestDTO);
        }
        return contestDtoList;
    }

    @Transactional
    public boolean contestMake(ContestMakeDTO contestInfo){
        // start-time, end-time 전처리
        LocalDateTime start_time = LocalDateTime.parse(contestInfo.getStart_time());
        LocalDateTime end_time = start_time.plusHours(contestInfo.getEnd_time());

        try {
            // contest 생성
            Contest contest = Contest.builder()
                    .contest_name(contestInfo.getContest_name())
                    .contest_description(contestInfo.getContest_description())
                    .startTime(start_time)
                    .endTime(end_time)
                    .build();

            Contest saveEntity = contestRepository.save(contest);

            List<Contest_Problem> problems = new ArrayList<>();
            for (ContestProblemDTO cpDTO : contestInfo.getProblems()) {
                Contest_Problem cp = Contest_Problem.builder()
                        .level(cpDTO.getLevel())
                        .problem_name(cpDTO.getProblem_name())
                        .problem_number(cpDTO.getProblem_number())
                        .contest(saveEntity)
                        .build();
                problems.add(cp);
            }

            contestProblemRepository.saveAll(problems);

            return true;
        } catch(Exception e){
            return false;
        }
    }
}
