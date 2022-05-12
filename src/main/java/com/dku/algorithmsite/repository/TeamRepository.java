package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Override
    List<Team> findAll();
}
