package tech.biuldrun.spotify.controller.dto;

public record CreateAlbumDto(String albumId, String spotifyId, String name,  String coverImage) {
    //criando os campos que vou receber na requisição
}
