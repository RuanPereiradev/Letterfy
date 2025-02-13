package tech.biuldrun.spotify.controller.dto;

import java.util.List;

public record AlbumResponseDto(String albumId, String spotifyId, String name, String coverImage,
                               List<tech.biuldrun.spotify.entity.Reviews> reviews) {
}
