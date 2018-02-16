package com.mediac.app.domain;

import com.mediac.app.entity.Account;
import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Created by pose2 on 2018-02-13.
 */
public class LoginUserDetails extends User {

    private static final long serialVersionUID = 1L;

    @Getter
    private long no;

    public LoginUserDetails(Account account){

        //일반적으로는 AuthorityUtils.createAuthorityList 에 다수의 룰을 넣고
        //account 테이블과 분리되어 별도의 권한테이블을 join 해서 가져와야하지만
        //예제가 길어지는 걸 방지하기위해 이렇게 만듦.
        super(
                account.getAc(),
                account.getPw(),
                AuthorityUtils.createAuthorityList(account.getRole())
        );

        no = account.getAccount_id();

    }

}
