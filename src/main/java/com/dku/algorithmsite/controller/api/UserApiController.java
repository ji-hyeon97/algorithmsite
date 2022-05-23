package com.dku.algorithmsite.controller.api;

import com.dku.algorithmsite.dto.ResponseDTO;
import com.dku.algorithmsite.model.User;
import com.dku.algorithmsite.repository.UserRepository;
import com.dku.algorithmsite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDTO<Long> signup(@RequestBody User user){
        userService.signUp(user);
        return new ResponseDTO<Long>(HttpStatus.OK.value(), 1L);
    }

    @GetMapping("/auth/valid_boj")
    public ResponseDTO<Boolean> validBoj(@RequestParam("id") String boj_id){
        boolean result = userService.validBoj(boj_id);
        System.out.println("result = " + result);
        return new ResponseDTO<Boolean>(HttpStatus.OK.value(), result);
    }
}
