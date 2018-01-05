package com.mediac.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentId;

    @Column(name = "comment_content", length = 500)
	private String commentContent;

    @Column(name = "comment_like")
	private int commentLike;

    @Column(name = "comment_dislike")
	private int commentDislike;

    @Column(name = "comment_playtime")
	private String commentPlaytime;

    @Column(name = "comment_postdate")
    @Temporal(TemporalType.TIMESTAMP)
	private Date commentPostdate;

    @Column(name = "comment_xpoint")
    private double commentXPoint;

    @Column(name = "comment_ypoint")
    private double commentYPoint;

    @ManyToOne
    @JoinColumn(name="video_id")
    private Video video;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "comment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PercentMap percentMap;

    public Comment() {
    }

    public Comment(String commentContent, int commentLike, int commentDislike, String commentPlaytime, Date commentPostdate, double commentXPoint, double commentYPoint, Video video, User user) {
        this.commentContent = commentContent;
        this.commentLike = commentLike;
        this.commentDislike = commentDislike;
        this.commentPlaytime = commentPlaytime;
        this.commentPostdate = commentPostdate;
        this.commentXPoint = commentXPoint;
        this.commentYPoint = commentYPoint;
        this.video = video;
        this.user = user;
    }
}
