package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.Contest_Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestProblemRepository extends JpaRepository<Contest_Problem, Long> {
}
