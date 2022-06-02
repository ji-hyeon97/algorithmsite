package com.dku.algorithmsite.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContestProblemDTO {
    private Long id;
    private Integer level;
    private Integer problem_number;
    private String problem_name;


}
