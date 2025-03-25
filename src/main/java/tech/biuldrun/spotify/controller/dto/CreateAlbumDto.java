package tech.biuldrun.spotify.controller.dto;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public record CreateAlbumDto(String spotifyId, String name, List<String> images, List<String> artists) {
    //criando os campos que vou receber na requisição

}
