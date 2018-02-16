package com.mediac.app.service;

import com.mediac.app.domain.LoginUserDetails;
import com.mediac.app.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by pose2 on 2018-02-13.
 * 인증 과정으로 유저가 입력한 id에 해당하는 정보를 불러와 LoginUserDetails에 바인딩하여
 * 반환합니다.
 */
@Service
public class LoginUserDetailsService implements UserDetailsService
{
    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String ac) throws UsernameNotFoundException {

        Account account = accountService.getAccount(ac);

        if(account == null){
            //계정이 존재하지 않음을 출력
            throw new UsernameNotFoundException("login fail");
        }

        return new LoginUserDetails(account);
    }
}
