package com.dku.algorithmsite.repository;

import com.dku.algorithmsite.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

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

    // boj_name으로 찾기
    public Optional<User> findByBojName(String boj_username){
        List<User> user = em.createQuery("select u from User u where u.boj_username = :boj_username", User.class)
                    .setParameter("boj_username", boj_username)
                    .getResultList();

        return user.stream().findAny();
    }
}
