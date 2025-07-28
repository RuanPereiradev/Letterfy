package tech.biuldrun.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import tech.biuldrun.spotify.entity.Albuns;

import java.util.List;
import java.util.Objects;

@Service
public class CacheService {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private AlbumService albumService;

    public void evictAllCacheValues(String cacheName){
        Objects.requireNonNull(cacheManager.getCache(cacheName), "Cache not found: " + cacheName).clear();
    }

    @CachePut("albuns")
    public List<Albuns> updateCacheAlbuns() {
        return albumService.findAllWithCache();
    }
}
