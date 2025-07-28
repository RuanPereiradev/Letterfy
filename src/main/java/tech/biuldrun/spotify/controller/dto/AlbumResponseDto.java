package tech.biuldrun.spotify.controller.dto;

import tech.biuldrun.spotify.entity.Albuns;
import java.util.List;
import java.util.stream.Collectors;

public record AlbumResponseDto(String albumId, String spotifyId, String name,
                               List<String> artists, List<String> images,
                               List<ReviewResponseDto> reviews) {

    public AlbumResponseDto(Albuns albuns) {
        this(
                albuns.getAlbumId().toString(),
                albuns.getSpotifyId(),
                albuns.getName(),
                albuns.getArtists(),
                albuns.getImages(),
                albuns.getReviews().stream()
                        .map(ReviewResponseDto::new)
                        .collect(Collectors.toList())
        );
    }
}

