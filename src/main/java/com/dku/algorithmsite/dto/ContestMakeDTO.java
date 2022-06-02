package com.dku.algorithmsite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContestMakeDTO {
    private String contest_name;
    private String contest_description;
    private String start_time;
    private Integer end_time;
    private List<ContestProblemDTO> problems;
}
