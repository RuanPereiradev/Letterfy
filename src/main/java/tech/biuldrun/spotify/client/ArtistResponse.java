package tech.biuldrun.spotify.client;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistResponse {

    private String id;
    private String name;
    private int popularity;
    private String href;
    private List<ImageArtist> images;
    private Followers followers;
    @JsonProperty("genres")
    private List<String> genres;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ImageArtist{
        private int height;
        private int width;
        private String url;
    }

    @Data
    public static class Followers{
        private int total;
    }
}
