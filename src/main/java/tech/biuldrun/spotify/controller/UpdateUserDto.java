package tech.biuldrun.spotify.controller;

public record UpdateUserDto(String username, String password) {   //record é uma classe imutavel
    //criando os campos que vou receber na requisição
}
