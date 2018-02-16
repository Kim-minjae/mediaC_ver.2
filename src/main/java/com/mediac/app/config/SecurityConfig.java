package com.mediac.app.config;

import com.mediac.app.service.LoginUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                //위 ignoring을 제외한 전체가 기본 인증페이지
                .antMatchers("/**").authenticated();

        http
                .formLogin()
                //로그인 페이지  : 컨트롤러 매핑을 하지 않으면 기본 제공되는 로그인페이지가 뜬다.
                .loginProcessingUrl("/login");

        http
                .logout()
                //logout을 호출할 경우 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //logout 성공한 후 이동할 페이지
                .logoutSuccessUrl("/"); // 기본페이지로 돌아오게함
    }

    @Configuration
    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter
    {
        @Autowired
        UserDetailsService userDetailsService; // UserDetailsService로 선언해서 하려고하니깐 Bean 이 두개 있다고 안된다고함, 그래서 떄려박음



    }
}
