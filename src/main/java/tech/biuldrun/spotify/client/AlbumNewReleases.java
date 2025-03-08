package tech.biuldrun.spotify.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumNewReleases {

    @JsonProperty("id")
    private String spotifyId;

    private String name;

    private String releaseDate;

    private int totalTracks;

    private List<Image> images;

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
