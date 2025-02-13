package tech.biuldrun.spotify.controller.dto;

public record SongResponseDto(String songId, String spotifyId, String name, String duration,
                              java.util.List<tech.biuldrun.spotify.entity.Reviews> reviews) {
}
