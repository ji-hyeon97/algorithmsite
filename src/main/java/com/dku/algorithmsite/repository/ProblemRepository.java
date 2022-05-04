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
        Problem result_problem = em.find(Problem.class, problem.getProblem_number());
        if(result_problem == null){
            em.persist(problem);
        }else{
            result_problem.setTier_url(problem.getTier_url());
        }
    }

    public void saveAll(List<Problem> problems,int pageNum){
        List<Problem> resultList = em.createQuery("select p from Problem p", Problem.class)
                .setFirstResult((pageNum-1) * 100)
                .setMaxResults(100)
                .getResultList();
        for(int i=0;i<resultList.size();i++){
            resultList.get(i).setTier_url(problems.get(i).getTier_url());
        }
        em.flush();
        for(int i= resultList.size();i<problems.size()-resultList.size();i++){
            em.persist(problems.get(i));
        }
    }

    public List<Problem> find(int pageNum){
        return em.createQuery("select p from Problem p",Problem.class)
                .setFirstResult((pageNum-1)*100)
                .setMaxResults(100)
                .getResultList();
    }
}
