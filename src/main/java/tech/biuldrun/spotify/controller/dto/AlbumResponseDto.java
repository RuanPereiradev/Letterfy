package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.Albuns;

import java.util.List;

public record AlbumResponseDto(String albumId, String spotifyId, String name, String coverImage,
                               List<tech.biuldrun.spotify.entity.Reviews> reviews) {
    public AlbumResponseDto(Albuns albuns) {
        this(String.valueOf(albuns.getAlbumId()), albuns.getSpotifyId(), albuns.getName(), albuns.getCoverImage(), albuns.getReviews());
    }
}
