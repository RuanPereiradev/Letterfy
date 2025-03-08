package tech.biuldrun.spotify.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumNewReleasesWrapper {

    private List<AlbumNewReleases> items;

    public List<AlbumNewReleases> getItems() {
        return items;
    }

}
