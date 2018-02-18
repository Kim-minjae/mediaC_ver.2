package com.mediac.app.repository;

import com.mediac.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Created by pose2 on 2018-02-13.
 */
public interface AccountRepository extends JpaRepository<Account, Long>
{
    @Query(value = "SELECT a FROM Account a WHERE a.ac = :ac")
    Account findOneByAc(@Param("ac") String ac);
}
