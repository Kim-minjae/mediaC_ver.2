package com.mediac.app.repository;

import com.mediac.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by pose2 on 2018-02-13.
 */
public interface AccountRepository extends JpaRepository<Account , Long> {
    @Query("SELECT a FROM account a where a.ac = :ac")
    public Account findOneByAc(@Param("ac") String ac);
}
