package tech.biuldrun.spotify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class AccountReviewId implements Serializable {
    @Column(name = "account_id")
    private UUID accountId;

    @Column(name = "review_id")
    private String reviewId;
}
