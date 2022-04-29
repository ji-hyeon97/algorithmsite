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
public class ProblemRefreshDTO {
    private int problem_number;

    private String tier_url;

    private String problem_name;

    public ProblemRefreshDTO(final Problem entity){
        this.problem_number = entity.getProblem_number();
        this.tier_url = entity.getTier_url();
        this.problem_name = entity.getProblem_name();
    }

    public static Problem toEntity(final ProblemRefreshDTO dto){
        return Problem.builder()
                .problem_number(dto.getProblem_number())
                .tier_url(dto.getTier_url())
                .problem_name(dto.getProblem_name())
                .build();
    }
}
