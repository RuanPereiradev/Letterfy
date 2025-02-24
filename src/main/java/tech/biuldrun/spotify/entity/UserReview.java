package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_review")
public class UserReview {

    @EmbeddedId
    private UserReviewId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "review_id")
    private Reviews review;

    @Column(name = "quantity")
    private Integer quantity;
}
