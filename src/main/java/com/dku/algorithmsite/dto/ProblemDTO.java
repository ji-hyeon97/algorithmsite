package com.dku.algorithmsite.dto;

import com.dku.algorithmsite.model.Problem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDTO {
    private int problem_number;

    private String tier_url;

    private String problem_name;

    public ProblemDTO(Problem problem){
        this.problem_number = problem.getProblem_number();
        this.tier_url = problem.getTier_url();
        this.problem_name = problem.getProblem_name();
    }

    public Problem toEntity(ProblemDTO dto){
        return Problem.builder()
                .problem_number(dto.getProblem_number())
                .tier_url(dto.getTier_url())
                .problem_name(dto.getProblem_name())
                .build();
    }
}
