package com.mediac.app.controller;

import com.mediac.app.domain.LoginUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping(path="/", produces="text/html")
    public String index()
    {
        return
                "index page<br/><a href=\"/mypage\">mypage</a>";
    }

    @RequestMapping(path="/mypage", produces="text/html")
    public String mypage(@AuthenticationPrincipal LoginUserDetails userDetails)
    {
        return
                "is mypage !!<br/>" +
                        userDetails.getNo() + " : " + userDetails.getUsername() +
                        "<br/><a href=\"/logout\">logout</a>";
    }
}
