package com.dku.algorithmsite.service;

import com.dku.algorithmsite.dto.ContestDto;
import com.dku.algorithmsite.model.Contest;
import com.dku.algorithmsite.repository.ContestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContestService {
    private ContestRepository contestRepository;

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
}
