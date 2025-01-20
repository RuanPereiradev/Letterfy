package tech.biuldrun.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "AlbumNewRealeasesSpotifyClient",
        url = "https://api.spotify.com"
)
public interface AlbumNewRealeasesSpotifyClient {

    @GetMapping(value = "/v1/browse/new-releases")
    AlbumNewReleasesResponse getReleases(@RequestHeader("Authorization")String authorization);
}
