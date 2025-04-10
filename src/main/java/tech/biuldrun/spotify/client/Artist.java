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
public class Artist {
    @JsonProperty("id")
    private String id;
    private ExternalUrls external_urls;
    private Followers followers;
    private List<String> genres;
    private String href;

    private List<Image> images;
    private String name;
    private int popularity;
    private String type;
    private String uri;

    @Data
    public static class ExternalUrls {
        private String spotify;
    }

    @Data
    public static class Followers {
        private int total;
    }

    @Data
    public static class Image {
        private String url;
        private int height;
        private int width;
    }
}