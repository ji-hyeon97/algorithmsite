package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    // 유저이름으로 찾기
    public User findByUsername(String username){
        return em.createQuery("select u from User u where u.username = :username",User.class)
                .setParameter("useranme",username)
                .getSingleResult();
    }
}
