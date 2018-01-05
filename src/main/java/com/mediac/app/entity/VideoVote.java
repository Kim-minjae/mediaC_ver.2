package com.mediac.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "video_vote")
@NoArgsConstructor
@AllArgsConstructor
public class VideoVote {

    @Id
    @Column(name = "videovote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long videoVoteId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;

    @Temporal(TemporalType.DATE)
    @Column(name = "vote_date")
    private Date voteDate;

}
