package tech.biuldrun.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.biuldrun.spotify.entity.UserReview;
import tech.biuldrun.spotify.entity.UserReviewId;

public interface UserReviewRepository extends JpaRepository<UserReview, UserReviewId> {

}

