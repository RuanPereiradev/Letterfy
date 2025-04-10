package tech.biuldrun.spotify.controller.dto;

public record ReviewResponseDto(String reviewId, String albumId, String login, java.math.BigDecimal rating, String comment,
                                String users) {

    //criando os campos que vou retornar na resposta
}
