package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
    //List<Contest> findByTitleContaining(String keyword);
}

