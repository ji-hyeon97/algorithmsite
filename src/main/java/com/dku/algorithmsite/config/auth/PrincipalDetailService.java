package com.dku.algorithmsite.config.auth;

import com.dku.algorithmsite.model.User;
import com.dku.algorithmsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User principal = userRepository.findByUsername(username);
        if(principal == null){
            throw new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.");
        }
        return new PrincipalDetail(principal);
    }
}
