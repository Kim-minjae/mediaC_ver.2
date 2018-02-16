package com.mediac.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pose2 on 2018-02-12.
 */
@RestController
public class MypageController {

    @RequestMapping( path = "/" , produces = "text/plain")
    public String home(){
        return "is Home !! ";
    }

    @RequestMapping( path = "/mypage" , produces = "text/plain")
    public String mypage(){
        return "is mypage !! ";
    }

}
