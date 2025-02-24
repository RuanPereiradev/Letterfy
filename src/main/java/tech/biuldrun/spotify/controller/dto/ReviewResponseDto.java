package tech.biuldrun.spotify.controller.dto;

public record ReviewResponseDto(String reviewId, String userId, String username, String comment, String albumId, String rating) {

    //criando os campos que vou retornar na resposta
}
