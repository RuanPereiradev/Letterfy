package tech.biuldrun.spotify.controller.dto;

import java.util.UUID;

public record CreateAlbumDto(String spotifyId, String name, String coverImage) {
    //criando os campos que vou receber na requisição
}
