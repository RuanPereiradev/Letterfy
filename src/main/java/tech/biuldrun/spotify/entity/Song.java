//package tech.biuldrun.spotify.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.UUID;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Table(name = "tb_songs")
//public class Song {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "song_id")
//    private UUID id;
//
//    @Column(name = "spotify_id", nullable = false, unique = true)
//    private String spotifyId; // ID externo fornecido pela API do Spotify
//
//    @ManyToOne
//    @JoinColumn(name = "album_id",referencedColumnName = "id")
//    private Albuns album;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "duration")
//    private String duration;
//
//    @PostLoad
//    private void onLoad() {
//        System.out.println("Song entity loaded: " + this);
//    }
//
//
//
//
//}
