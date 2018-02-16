package com.mediac.app.service;

import com.mediac.app.entity.Account;
import com.mediac.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by pose2 on 2018-02-13.
 */
@Component
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account getAccount(String ac)
    {
        return accountRepository.findOneByAc(ac);
    }
}
