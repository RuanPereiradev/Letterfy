package tech.biuldrun.spotify.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity
@Table(name = "tb_albuns")
public class Albuns {

    @Setter
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



    @OneToMany(mappedBy = "albuns", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude//se tirar da merda
    private List<Reviews> reviews;

    @CreationTimestamp//indica que o campo é um timestamp
    private Instant createdAt;

    public Albuns(String spotifyId, String name, String coverImage) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.coverImage = coverImage;

    }


    @PostLoad
    private void onLoad() {
        System.out.println("Album entity loaded: " + this);
    }

}
