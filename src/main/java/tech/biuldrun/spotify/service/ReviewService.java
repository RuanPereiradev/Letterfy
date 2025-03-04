package tech.biuldrun.spotify.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.CreateReviewDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.entity.Reviews;
import tech.biuldrun.spotify.entity.User;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.repository.ReviewRepository;
import tech.biuldrun.spotify.repository.UserRepository;

import java.util.List;
import java.util.UUID;
@Service
public class ReviewService {

    private AuthenticationManager authenticationManager;


    private  ReviewRepository reviewRepository;
    private UserRepository userRepository;
    private  AlbumRepository albumRepository; // ✅ Adicionando AlbumRepository

    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, AlbumRepository albumRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.albumRepository = albumRepository;// ✅ Inicializando o AlbumRepository
    }

    public void createReview(CreateReviewDto createReviewDto) {
        var authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.login(authenticatedUser.getLogin())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        Albuns album = albumRepository.findById(UUID.fromString(createReviewDto.albumId())) // ✅ Agora albumRepository está disponível
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found"));

        Reviews review = new Reviews();
        review.setRating(createReviewDto.rating());
        review.setComment(createReviewDto.comment());
        review.setUser(user);
        review.setAlbuns(album);

        reviewRepository.save(review);
    }



}




