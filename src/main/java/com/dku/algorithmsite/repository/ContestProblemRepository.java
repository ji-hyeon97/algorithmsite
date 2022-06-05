package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.Contest_Problem;
import com.dku.algorithmsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface ContestProblemRepository extends JpaRepository<Contest_Problem, Long> {

    public List<Contest_Problem> findByContest_id(Long contest_id);
}
