package tech.biuldrun.spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.biuldrun.spotify.controller.dto.AlbumResponseDto;
import tech.biuldrun.spotify.controller.dto.CreateAlbumDto;
import tech.biuldrun.spotify.entity.Albuns;
import tech.biuldrun.spotify.repository.AlbumRepository;
import tech.biuldrun.spotify.service.AlbumService;
import tech.biuldrun.spotify.service.UserService;

import java.util.List;

@RestController
@RequestMapping("v1/album")
public class MyAlbumController {

    @Autowired
    AlbumRepository  albumRepository;

    private AlbumService albumService;
    @Autowired
    private UserService userService;

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

    @DeleteMapping("/{albumId}")
    public ResponseEntity<Void> deleteById(@PathVariable("albumId") String albumId){
        albumService.deleteById(albumId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public List<AlbumResponseDto>getAlbunsByName(@RequestParam String name){
        return albumService.getAlbunsByName(name);  

    }

}
