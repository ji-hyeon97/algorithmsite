package com.dku.algorithmsite.handler;

import com.dku.algorithmsite.config.auth.PrincipalDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class GlobalExceptionHandler implements ErrorController {

    @GetMapping("/errorPage")
    public String handleError(HttpServletRequest request,Model model, @AuthenticationPrincipal PrincipalDetail principal) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        log.warn("Error code : {}",status);

        model.addAttribute("status",status);
        model.addAttribute("principal",principal);
        if(principal != null) {
            model.addAttribute("boj_username", principal.getBoj_username());
        }

        return "error/errorPage";
    }
}
