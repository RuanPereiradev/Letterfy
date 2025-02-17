package tech.biuldrun.spotify.controller.dto;

public record AuthenticationDto(String email, String password) {
    //criando os campos que vou receber na requisição
}
