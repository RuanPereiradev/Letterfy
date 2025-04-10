package tech.biuldrun.spotify.controller.dto;

import java.math.BigDecimal;


public record CreateReviewDto(String login, String albumId, BigDecimal rating, String comment) {
    //criando os campos que vou receber na requisição

}
