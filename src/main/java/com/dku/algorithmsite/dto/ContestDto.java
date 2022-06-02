package com.dku.algorithmsite.dto;

import com.dku.algorithmsite.model.Contest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContestDto {
    private Long id;
    private String contest_name;
    private String contest_description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer avg_level;

    public Contest toEntity(){
        Contest contest = Contest.builder()
                .contest_name(contest_name)
                .contest_description(contest_description)
                .startTime(startTime)
                .endTime(endTime)
                .avg_level(avg_level)
                .build();
        return contest;
    }

    @Builder
    public ContestDto(Long id, String contest_name, String contest_description, LocalDateTime startTime, LocalDateTime endTime,Integer avg_level) {
        this.id = id;
        this.contest_name= contest_name;
        this.contest_description = contest_description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.avg_level = avg_level;
    }
}