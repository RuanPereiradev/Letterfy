package tech.biuldrun.spotify.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.CreateReviewDto;
import tech.biuldrun.spotify.entity.Account;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.entity.Reviews;

import tech.biuldrun.spotify.repository.AccountRepository;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.repository.ReviewRepository;

import java.util.UUID;
@Service
public class ReviewService {

    private  ReviewRepository reviewRepository;
    private  AccountRepository accountRepository;
    private  AlbumRepository albumRepository; // ✅ Adicionando AlbumRepository

    public ReviewService(ReviewRepository reviewRepository, AccountRepository accountRepository, AlbumRepository albumRepository) {
        this.reviewRepository = reviewRepository;
        this.accountRepository = accountRepository;
        this.albumRepository = albumRepository;// ✅ Inicializando o AlbumRepository
    }

    public void createReview(CreateReviewDto createReviewDto) {
        Account account = accountRepository.findById(UUID.fromString(createReviewDto.accountId()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));

        Albuns album = albumRepository.findById(UUID.fromString(createReviewDto.albumId())) // ✅ Agora albumRepository está disponível
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Album not found"));

        Reviews review = new Reviews();
        review.setRating(createReviewDto.rating());
        review.setComment(createReviewDto.comment());
        review.setAccount(account);
        review.setAlbuns(album);

        reviewRepository.save(review);
    }

}




