package tech.biuldrun.spotify.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "TrackSpotifyClient",
        url = "https://api.spotify.com"
)


public interface TrackSpotifyClient {
    @GetMapping(value = "/v1/tracks/{id}")
    TrackResponse getTrack(@RequestHeader("Authorization") String autorization,
                           @PathVariable("id") String trackId
    );
}
