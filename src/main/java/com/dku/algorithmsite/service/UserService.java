package com.dku.algorithmsite.service;

import com.dku.algorithmsite.model.RoleType;
import com.dku.algorithmsite.model.User;
import com.dku.algorithmsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void signUp(User user){
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.signUp(user);
    }

    public boolean validBoj(String boj_name){
        Optional<User> byBojName = userRepository.findByBojName(boj_name);
        if(byBojName.isEmpty()) return false;
        return true;
    }
}
