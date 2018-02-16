package com.mediac.app.config;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/**");  //모든 페이지를 인증이 된 페이지로 만들어버림.
    }

}
