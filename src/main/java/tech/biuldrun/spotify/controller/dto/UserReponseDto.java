package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.UserRole;

import java.util.UUID;

public record UserReponseDto (UUID userId, String login, UserRole role) {

    //criando os campos que vou retornar na resposta
}
