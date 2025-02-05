package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.entity.Account;
import tech.biuldrun.spotify.entity.AccountReview;
import tech.biuldrun.spotify.entity.AccountReviewId;

import java.util.UUID;

public interface AccountReviewRepository extends JpaRepository<AccountReview, AccountReviewId> {

}

