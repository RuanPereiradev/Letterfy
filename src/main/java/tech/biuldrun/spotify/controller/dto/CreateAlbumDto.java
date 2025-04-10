package tech.biuldrun.spotify.controller.dto;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public record CreateAlbumDto(String spotifyId, String name, List<String> artists,  List<String> images) {
    //criando os campos que vou receber na requisição

}
