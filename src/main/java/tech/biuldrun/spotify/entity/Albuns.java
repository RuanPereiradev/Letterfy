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
    @GeneratedValue(strategy = GenerationType.UUID) // Gerando UUID como chave primária
    @Column(name = "album_id")
    private UUID albumId;

    @Column(name = "spotify_id", nullable = false, unique = true)
    private String spotifyId; // ID fornecido pela API do Spotify

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "artists_name", joinColumns = @JoinColumn(name = "album_id"))
    @Column(name = "artists")
    private List<String> artists;

    // Armazenando os links das imagens em uma coleção separada
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "album_images", joinColumns = @JoinColumn(name = "album_id"))
    @Column(name = "image_url")
    private List<String> images;

    @OneToMany(mappedBy = "albuns", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Exclude // Evita a impressão de reviews ao chamar toString()
    private List<Reviews> reviews;

    @CreationTimestamp // Indica que o campo será preenchido automaticamente com o timestamp da criação
    private Instant createdAt;

    // Construtor para a criação de novos álbuns com as imagens
    public Albuns(String spotifyId, String name, List<String> images, List<String> artists) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.images = images;
        this.artists = artists;
    }

   

    // Método que será executado quando a entidade for carregada
    @PostLoad
    private void onLoad() {
        System.out.println("Album entity loaded: " + this);
    }
}
