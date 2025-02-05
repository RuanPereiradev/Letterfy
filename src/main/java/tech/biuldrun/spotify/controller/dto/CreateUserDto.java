package tech.biuldrun.spotify.controller.dto;

import lombok.Data;

public record CreateUserDto(String username, String email, String password) {   //record é uma classe imutavel
    //criando os campos que vou receber na requisição
}
