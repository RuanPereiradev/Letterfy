package tech.biuldrun.spotify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.service.AlbumService;

import java.util.List;

@RestController
@RequestMapping("v1/album")
public class MyAlbumController {

    private AlbumService albumService;

    public MyAlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @PostMapping
    public ResponseEntity<Void> createAlbum(@RequestBody CreateAlbumDto createAlbumDto) {
        albumService.createAlbum(createAlbumDto);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<Albuns>> listAlbuns(){
        var albuns = albumService.listAlbuns();
        return ResponseEntity.ok(albuns);
    }

    @GetMapping("/{albumId}")
        public ResponseEntity<AlbumResponseDto>getAlbunsById(@PathVariable("albumId") String albumId){
        AlbumResponseDto albumResponseDto = albumService.getAlbumById(albumId);
        return ResponseEntity.ok(albumResponseDto);
    }





}
