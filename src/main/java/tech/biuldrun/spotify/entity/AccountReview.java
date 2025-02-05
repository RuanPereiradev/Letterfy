package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_account_review")
public class AccountReview {

    @EmbeddedId
    private AccountReviewId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "review_id")
    private Reviews review;

    @Column(name = "quantity")
    private Integer quantity;
}
