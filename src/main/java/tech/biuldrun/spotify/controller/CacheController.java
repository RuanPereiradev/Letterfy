package tech.biuldrun.spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.service.AlbumService;
import tech.biuldrun.spotify.service.CacheService;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @PostMapping
    public void clear(@RequestParam("cacheName")String cacheName){
        cacheService.evictAllCacheValues(cacheName);
    }

    @PutMapping
    public void update(){
        cacheService.updateCacheAlbuns();
    }
}
