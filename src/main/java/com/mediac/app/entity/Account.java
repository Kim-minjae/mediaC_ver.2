package com.mediac.app.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by pose2 on 2018-02-13.
 */
@Entity
@Data
public class Account {

    @Id
    @Column(name = "account_id")
    @SequenceGenerator(name = "seq" , sequenceName = "account_no_sequence", allocationSize = 1)
    // MySql 에서 사용될 sequence gen을 어떻게 설정할지몰라 우선 여기서 설정한다.
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seq")
    private Long account_id;

    @Column(unique = true, nullable = false)
    String ac;

    @Column(nullable = false)
    String pw;

    @Column(nullable = false)
    String role;

    public void setAc(String ac) {
        this.ac = ac.toLowerCase();
    }
}
