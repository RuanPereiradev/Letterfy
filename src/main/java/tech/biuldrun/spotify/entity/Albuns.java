package tech.biuldrun.spotify.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
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
    private UUID userId;

    private String name;

    private String coverImage;

//    private Artist artistId;

    private Date realeseDate;

//    private Genre genreId;


    @CreationTimestamp//indica que o campo é um timestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "albuns")
    private List<Reviews> reviews;
}
