package tech.biuldrun.spotify.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.biuldrun.spotify.controller.dto.CreateSongDto;
import tech.biuldrun.spotify.controller.dto.SongResponseDto;
import tech.biuldrun.spotify.entity.Song;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.repository.SongRepository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class SongService {


    private SongRepository songRepository;

    //criação das musicas e devidos testes
    public void createSong(CreateSongDto createSongDto){
        if(songRepository.existsBySpotifyId(createSongDto.spotifyId())){
            throw new IllegalArgumentException("Song already exists(spotifyId)");
        }
        if(songRepository.existsByName(createSongDto.name())){
            throw new IllegalArgumentException("Song already exists(name)");
        }

        //dto->entity

        var song = new Song(
                UUID.randomUUID(),
                createSongDto.spotifyId(),
                createSongDto.name(),
                createSongDto.duration()
        );
        songRepository.save(song);
    }

    //Listando todas as musicas cadastradas
    public List<Song> listSongs() {return songRepository.findAll();}

    public SongResponseDto getSongsById(String songId) {
        Song song  = songRepository.findBySongId(UUID.fromString(songId))
                .orElseThrow(()-> new RuntimeException("Song not found"));

        return new SongResponseDto(
                song.getSongId().toString(),
                song.getSpotifyId(),
                song.getName(),
                song.getDuration(),
                song.getReviews()

        );
    }
}
