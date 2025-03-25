package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.entity.Reviews;

import java.util.List;

public record AlbumResponseDto(String albumId, String spotifyId, String name, List<String> artists,
                               List<Reviews> reviews) {

    public AlbumResponseDto(Albuns albuns) {
        this(
                String.valueOf(albuns.getAlbumId()),
                albuns.getSpotifyId(),
                albuns.getName(),
                albuns.getArtists(), // Agora está correto
                albuns.getReviews()
        );
    }
}
