package com.mediac.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Video {

    @Id
    @Column(name = "video_id")
    @GeneratedValue
    private Long videoId;

    @Column(name = "video_title", length = 50)
    private String videoTitle;

    @Column(name = "video_postdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date videoPostDate;

    @Column(name = "video_content", length = 1000)
    private String videoContent;

    @Column(name = "video_code")
    private int videoCode;

    @Column(name = "video_like")
    private int videoLike;

    @Column(name = "video_dislike")
    private int videoDislike;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Video() {
    }

    public Video(String videoTitle, Date videoPostDate, String videoContent, int videoCode, int videoLike, int videoDislike, User user, List<Comment> comments) {
        this.videoTitle = videoTitle;
        this.videoPostDate = videoPostDate;
        this.videoContent = videoContent;
        this.videoCode = videoCode;
        this.videoLike = videoLike;
        this.videoDislike = videoDislike;
        this.user = user;
        this.comments = comments;
    }
}
