package tech.biuldrun.spotify.controller.dto;

public record ReviewResponseDto(String reviewId,String albumId, String login,String rating, String comment  ) {

    //criando os campos que vou retornar na resposta
}
