package tech.biuldrun.spotify.service;

import org.springframework.stereotype.Service;
//import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.repository.ReviewRepository;



import java.util.List;
import java.util.UUID;

@Service
public class AlbumService {


    private  AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
             this.albumRepository = albumRepository;
    }



    public void createAlbum(CreateAlbumDto createAlbumDto) {
        if(albumRepository.existsBySpotifyId(createAlbumDto.spotifyId())) {
            throw new IllegalArgumentException("Album already exists(SpotifyId)");
        }
        if (albumRepository.existsByName(createAlbumDto.name())) {
            throw new IllegalArgumentException("Album already exists(name)");
        }
        //dto->entity
        var album = new Albuns(
                createAlbumDto.name(),
                createAlbumDto.spotifyId(),
                createAlbumDto.coverImage()
                );

        albumRepository.save(album);

    }

    public List<Albuns> listAlbuns() {
        return albumRepository.findAll();
    }



    public AlbumResponseDto getAlbumById(String albumId){
        Albuns albuns = albumRepository.findByAlbumId(UUID.fromString(albumId))
                .orElseThrow(()-> new RuntimeException("Album not found"));

        return new AlbumResponseDto(
                albuns.getAlbumId().toString(),
                albuns.getSpotifyId(),
                albuns.getName(),
                albuns.getCoverImage(),
                albuns.getReviews()
        );
    }
}
