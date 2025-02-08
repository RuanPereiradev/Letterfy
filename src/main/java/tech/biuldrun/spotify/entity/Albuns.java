package tech.biuldrun.spotify.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_albuns")
public class Albuns {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "album_id")
    private UUID albumId;


    @Column(name = "spotify_id", nullable = false, unique = true)
    private String spotifyId; // ID fornecido pela API do Spotify/ ID externo fornecido pela API do Spotify

    @Column(name = "name")
    private String name;

    @Column(name = "cover_image")
    private String coverImage;



    @OneToMany(mappedBy = "albuns", fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude//se tirar da merda
    private List<Reviews> reviews;

    @CreationTimestamp//indica que o campo é um timestamp
    private Instant createdAt;

    public Albuns(UUID albumId, String spotifyId, String name, String coverImage) {
        this.albumId = albumId;
        this.spotifyId = spotifyId;
        this.name = name;
        this.coverImage = coverImage;

    }


    @PostLoad
    private void onLoad() {
        System.out.println("Album entity loaded: " + this);
    }

}
