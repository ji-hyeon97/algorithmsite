package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    // 회원가입
    @Transactional
    public void signUp(User user){
        em.persist(user);
//        User findUser = findByUsername(user.getUsername()); // 유저 닉네임 검색
//        if(findUser == null){ // 존재하지 않으면 추가
//            em.persist(user);
//            return user.getUsername();
//        }else{ // 존재하면 null 리턴
//            return null;
//        }
    }

    // 유저이름으로 찾기
    public User findByUsername(String username){
        return em.createQuery("select u from User u where u.username = :username",User.class)
                .setParameter("username",username)
                .getSingleResult();
    }
}
