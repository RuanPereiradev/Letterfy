//package tech.biuldrun.spotify.service;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import tech.biuldrun.spotify.controller.dto.CreateReviewDto;
//import tech.biuldrun.spotify.entity.AccountReview;
//import tech.biuldrun.spotify.entity.AccountReviewId;
//import tech.biuldrun.spotify.entity.Reviews;
//import tech.biuldrun.spotify.repository.AccountRepository;
//import tech.biuldrun.spotify.repository.AccountReviewRepository;
//import tech.biuldrun.spotify.repository.ReviewRepository;
//
//import java.util.UUID;
//
//@Service
//public class AccountService {
//
//    private final AccountRepository accountRepository;
//    private final ReviewRepository reviewRepository;
//
//    public AccountService(AccountRepository accountRepository, ReviewRepository reviewRepository) {
//        this.accountRepository = accountRepository;
//        this.reviewRepository = reviewRepository;
//    }
//
//    public void createReview(String accountId, CreateReviewDto createReviewDto) {
//        // Buscar a Account no banco
//        var account = accountRepository.findById(UUID.fromString(accountId))
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found"));
//
//        // Criar uma nova review associada à Account
//        var review = new Reviews(
//                createReviewDto.rating(),
//                createReviewDto.comment()
//        );
//        review.setAccount(account); // Associar a account à review
//
//        // Salvar no banco
//        reviewRepository.save(review);
//    }
//}
//
