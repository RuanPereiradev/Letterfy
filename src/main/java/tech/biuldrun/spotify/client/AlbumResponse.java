package tech.biuldrun.spotify.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponse {

        private String name;
        private String id;
        private String href;
        private String releaseDate;
        private int totalTracks;
        private String albumType;
        private int popularity;
        private List<Image> images;
        private List<Artist> artists;

        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Image {
            private int height;
            private int width;
            private String url;
        }
        @Data
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Artist {
            private String name;
            private String id;
            private String href;
        }

}
