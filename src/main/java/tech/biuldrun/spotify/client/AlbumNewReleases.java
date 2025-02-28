package tech.biuldrun.spotify.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumNewReleases {

    @JsonProperty("id")
    private String spotifyId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("total_tracks")
    private int totalTracks;

    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("artists")
    private List<Artist> artists;


    // Classe interna para a imagem (capa do álbum)
    @Data
    public static class Image {
        private String url;
        private int height;
        private int width;
    }

    @Data
    public static class Artist {
        private String id;
        private String name;
    }
}
