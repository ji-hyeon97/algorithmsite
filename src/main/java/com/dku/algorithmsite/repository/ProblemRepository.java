package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.Problem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProblemRepository {

    private final EntityManager em;

    public void save(Problem problem){
        em.persist(problem);
    }

    public void saveAll(List<Problem> problems){
        int cnt = 0;
        for(Problem p : problems){
            em.persist(p);
            cnt++;
            if(cnt == 500) {
                em.flush();
                cnt = 0;
            }
        }
    }
}
