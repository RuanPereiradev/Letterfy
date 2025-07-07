package tech.biuldrun.spotify.service;

<<<<<<< HEAD
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
=======
import jakarta.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 441102582e3d508c87b3e78c2f4b003587f6334f
import org.springframework.stereotype.Service;
//import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import org.springframework.web.server.ResponseStatusException;
import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.controller.dto.ReviewResponseDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.repository.ReviewRepository;



import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlbumService {


<<<<<<< HEAD
    private AlbumRepository albumRepository;
=======

    @Autowired
    private  AlbumRepository albumRepository;
>>>>>>> 441102582e3d508c87b3e78c2f4b003587f6334f


    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    @CachePut(value = "ALBUM_CACHE", key = "#result.albumId()")
    public void createAlbum(CreateAlbumDto createAlbumDto) {

        if (albumRepository.existsBySpotifyId(createAlbumDto.spotifyId())) {
            throw new IllegalArgumentException("Album already exists(SpotifyId)");
        }
        if (albumRepository.existsByName(createAlbumDto.name())) {
            throw new IllegalArgumentException("Album already exists(name)");
        }
        //dto->entity
        var album = new Albuns(
                createAlbumDto.spotifyId(),
                createAlbumDto.name(),
                createAlbumDto.artists(),
                createAlbumDto.images()
        );
        albumRepository.save(album);

    }

<<<<<<< HEAD
    public List<AlbumResponseDto> listAlbuns() {
        return albumRepository.findAll().stream()
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public AlbumResponseDto getAlbumById(String albumId) {
=======
    @Cacheable("albuns")
    public List<Albuns> findAllWithCache(){
        return listAlbuns();
    }

    public List<Albuns> listAlbuns() {
        return albumRepository.findAll();
    }




    public AlbumResponseDto getAlbumById(String albumId){
>>>>>>> 441102582e3d508c87b3e78c2f4b003587f6334f
        Albuns albuns = albumRepository.findByAlbumId(UUID.fromString(albumId))
                .orElseThrow(() -> new RuntimeException("Album not found"));
        return new AlbumResponseDto(
                albuns.getAlbumId().toString(),
                albuns.getSpotifyId(),
                albuns.getName(),
                albuns.getArtists(), // ← Corrigido aqui
                albuns.getImages(),
                albuns.getReviews().stream()
                        .map(ReviewResponseDto::new)
                        .collect(Collectors.toList())
        );

    }

    public List<AlbumResponseDto> getAlbunsByName(String name){
       List<Albuns> albuns = albumRepository.findByNameContainingIgnoreCase(name);
       if(albuns.isEmpty()){
           throw new RuntimeException("No albuns found with name similar to: "+ name);
       }
        return albuns.stream()
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());

    }

    @CacheEvict(value = "ALBUM_CACHE", key = "#albumId")
    public void deleteById(String albumId) {

    var id = UUID.fromString(albumId);
    var albumExists = albumRepository.existsByAlbumId(id);
    if(albumExists){
        albumRepository.deleteById(id);
    }

    }

}