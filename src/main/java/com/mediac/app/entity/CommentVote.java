package com.mediac.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comment_vote")
@NoArgsConstructor
@AllArgsConstructor
public class CommentVote {

    @Id
    @Column(name = "commentvote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentVoteId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Temporal(TemporalType.DATE)
    @Column(name = "vote_date")
    private Date voteDate;

}
