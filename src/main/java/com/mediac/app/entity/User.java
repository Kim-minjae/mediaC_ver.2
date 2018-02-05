package com.mediac.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString(exclude = "userPassword")
@Entity
public class User implements Serializable {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "user_email", nullable = false, unique = true, length = 64)
    private String userEmail;

    @JsonIgnore
    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_nickname", nullable = false, length = 16)
    private String userNickname;

    @Temporal(TemporalType.DATE)
    @Column(name = "user_date")
    private Date userDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Video> videos = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public void setUserPassword(String userPassword) {
        this.userPassword = PASSWORD_ENCODER.encode(userPassword);
    }

    public User() {

    }

    public User(String userEmail, String userPassword, String userNickname) {
        this.userEmail = userEmail;
        setUserPassword(userPassword);
        this.userNickname = userNickname;
        this.userDate = new Date();
    }

    public User(String userEmail, String userPassword, String userNickname, Date userDate, List<Video> videos, List<Comment> comments) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userDate = new Date();
        this.videos = videos;
        this.comments = comments;
    }
}
