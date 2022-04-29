package com.dku.algorithmsite.dto;

import com.dku.algorithmsite.model.Problem;
import com.dku.algorithmsite.model.ProblemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemRefreshDTO {
    private int problem_number;

    private String tier_url;

    private String problem_name;

    private ProblemStatus status;

    public ProblemRefreshDTO(final Problem entity){
        this.problem_number = entity.getProblem_number();
        this.tier_url = entity.getTier_url();
        this.problem_name = entity.getProblem_name();
        this.status = entity.getStatus();
    }

    public static Problem toEntity(final ProblemRefreshDTO dto){
        return Problem.builder()
                .problem_number(dto.getProblem_number())
                .tier_url(dto.getTier_url())
                .problem_name(dto.getProblem_name())
                .status(dto.getStatus())
                .build();
    }
}
