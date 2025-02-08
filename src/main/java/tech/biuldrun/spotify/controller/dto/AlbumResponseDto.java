package tech.biuldrun.spotify.controller.dto;

import java.util.List;
import java.util.UUID;

public record AlbumResponseDto(String albumId, String spotifyId, String name, String coverImage) {
}
