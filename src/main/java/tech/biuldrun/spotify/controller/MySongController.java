package tech.biuldrun.spotify.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.controller.dto.CreateSongDto;
import tech.biuldrun.spotify.controller.dto.SongResponseDto;
import tech.biuldrun.spotify.entity.Song;
import tech.biuldrun.spotify.service.AlbumService;
import tech.biuldrun.spotify.service.SongService;

import java.util.List;

@RestController
@RequestMapping("v1/song")
public class MySongController {

    private  SongService songService;

    public MySongController(SongService songService){
        this.songService = songService;
    }
    @PostMapping
    public ResponseEntity<Void> createSong(@RequestBody CreateSongDto createSongDto){
        songService.createSong(createSongDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Song>> listSongs(){
        var songs = songService.listSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/{songId}")
    public ResponseEntity<SongResponseDto>getSongsById(@PathVariable("songId") String songId){
        SongResponseDto songResponseDto = songService.getSongsById(songId);
        return ResponseEntity.ok(songResponseDto);
    }

}
