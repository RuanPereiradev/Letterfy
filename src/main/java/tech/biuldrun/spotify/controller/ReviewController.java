package tech.biuldrun.spotify.controller;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.CreateReviewDto;
import tech.biuldrun.spotify.service.ReviewService;
@AllArgsConstructor
@RestController
@RequestMapping("/v1/review")
public class ReviewController {

    private ReviewService reviewService;

    @PostConstruct
    public void init() {
        System.out.println("ReviewController carregado!");
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIM')")
    public ResponseEntity<Void> createReview(@RequestBody CreateReviewDto createReviewDto) {
        System.out.println("Recebida requisição para criar review: " + createReviewDto);
        reviewService.createReview(createReviewDto);
        return ResponseEntity.ok().build();
    }

}


