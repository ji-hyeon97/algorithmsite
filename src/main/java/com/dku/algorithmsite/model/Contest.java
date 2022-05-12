package com.dku.algorithmsite.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contest {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

//    @OneToMany(mappedBy = "contest")
//    private List<Contest_Problem> contest_problems = new ArrayList<>();
}
