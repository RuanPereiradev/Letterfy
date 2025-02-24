package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
    //criando os campos que vou receber na requisição
}
