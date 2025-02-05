package tech.biuldrun.spotify.client;

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
public class TrackResponse {

    private String name;
    private String id;
    private String href;
    private List<Artist> artists;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Artist {
        private String name;
        private String id;
        private String href;
    }



}
