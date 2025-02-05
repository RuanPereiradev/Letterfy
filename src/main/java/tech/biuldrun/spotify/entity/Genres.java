//package tech.biuldrun.spotify.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.UUID;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@Entity
//@Table(name = "tb_genres")
//public class Genres {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id")
//    private UUID id;
//
//    @Column(name = "spotify_id", nullable = false, unique = true)
//    private String spotifyId; // ID externo fornecido pela API do Spotify
//
//
//    @Column(name = "name")
//    private String name;
//
//    @OneToMany(mappedBy = "genre")
//    private List<Albuns> albuns;
//
//    @PostLoad
//    private void onLoad() {
//        System.out.println("Genre entity loaded: " + this);
//    }
//
//}
