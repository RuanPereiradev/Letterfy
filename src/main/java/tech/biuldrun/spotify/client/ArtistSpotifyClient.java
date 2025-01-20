package tech.biuldrun.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "ArtistSpotifyClient",
        url = "https://api.spotify.com"
)
public interface ArtistSpotifyClient {

    @GetMapping(value = "/v1/artists/{id}")
    ArtistResponse getArtist(@RequestHeader("Authorization") String authorization,
                             @PathVariable("id") String artistaId
    );
}
