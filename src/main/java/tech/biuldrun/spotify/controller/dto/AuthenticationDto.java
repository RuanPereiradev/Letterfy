package tech.biuldrun.spotify.controller.dto;

public record AuthenticationDto(String login, String password) {
    //criando os campos que vou receber na requisição
}
