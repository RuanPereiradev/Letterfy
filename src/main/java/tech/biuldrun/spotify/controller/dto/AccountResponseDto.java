package tech.biuldrun.spotify.controller.dto;

public record AccountResponseDto(
        String accountId,
        String provider,
        String providerId,
        String userId,
        String userName,
        String email
){   //record é uma classe imutavel
    //criando os campos que vou retornar na resposta
}
