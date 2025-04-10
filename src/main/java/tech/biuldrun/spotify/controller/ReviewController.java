package tech.biuldrun.spotify.controller;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.CreateReviewDto;
import tech.biuldrun.spotify.controller.dto.ReviewResponseDto;
import tech.biuldrun.spotify.service.ReviewService;

import java.util.UUID;

@AllArgsConstructor
@RestController()
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @PostConstruct
    public void init() {
        System.out.println("ReviewController carregado!");
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> createReview(@AuthenticationPrincipal UserDetails user, @RequestBody CreateReviewDto createReviewDto) {
        reviewService.createReview(createReviewDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewResponseDto>getReviewsById(@PathVariable("reviewId") String reviewId){
      ReviewResponseDto reviewResponseDto = reviewService.getReviewsById(UUID.fromString(reviewId));
        return ResponseEntity.ok(reviewResponseDto);
    }


}


