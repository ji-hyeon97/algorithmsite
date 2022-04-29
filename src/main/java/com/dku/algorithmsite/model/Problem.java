package com.dku.algorithmsite.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    @Id
    @GeneratedValue
    private Long id;

    private int problem_number;

    private String tier_url;

    private String problem_name;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'NONE'")
    private ProblemStatus status;
}
