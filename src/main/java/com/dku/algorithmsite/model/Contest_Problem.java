package com.dku.algorithmsite.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contest_Problem {

    @Id
    @GeneratedValue
    private Long id;

    private int level;

    private int problem_number;

    private String problem_name;

    @ManyToOne
    @JoinColumn(name = "contest_id")
    private Contest contest;
}
