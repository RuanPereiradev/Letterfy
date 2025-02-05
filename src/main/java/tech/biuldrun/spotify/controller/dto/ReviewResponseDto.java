package tech.biuldrun.spotify.controller.dto;

public record ReviewResponseDto(String reviewId, String accountId, String username, String comment, String albumId, String rating) {

    //criando os campos que vou retornar na resposta
}
