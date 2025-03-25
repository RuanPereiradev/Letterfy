package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_album_images")
public class AlbumImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "height")
    private Integer height;
    @Column(name = "width")
    private  Integer width;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Albuns albuns;

    public AlbumImage(String imageUrl, Integer height, Integer width, Albuns album) {
        this.imageUrl = imageUrl;
        this.height = height;
        this.width = width;
        this.albuns = albuns;
    }
}
