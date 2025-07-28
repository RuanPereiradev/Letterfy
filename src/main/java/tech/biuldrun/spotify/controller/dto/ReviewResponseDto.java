package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.Reviews;

import java.math.BigDecimal;

public record ReviewResponseDto(String reviewId, String albumId, String login,
                                BigDecimal rating, String comment, String users) {
    public ReviewResponseDto(Reviews review) {
        this(
                review.getReviewId().toString(),
                review.getAlbuns().getAlbumId().toString(),
                review.getLogin(),
                review.getRating(),
                review.getComment(),
                String.valueOf(review.getUser())
        );
    }
}

