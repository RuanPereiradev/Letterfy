package tech.biuldrun.spotify.controller;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createReview(@RequestBody CreateReviewDto createReviewDto) {
        System.out.println("Recebida requisição para criar review: " + createReviewDto);
        reviewService.createReview(createReviewDto);
        return ResponseEntity.ok().build();
    }
}

//
//    @GetMapping("/album/{albumId}")
//    public ResponseEntity<Void> getReviewsByAlbumId(@PathVariable String albumId) {
//
//      var reviews =   reviewService.getReviewsByAlbumId(albumId);
//
//        return  ResponseEntity.ok(reviews);
//
//    }
//}
