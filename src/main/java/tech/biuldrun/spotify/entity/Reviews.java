package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID reviewsId;

    @ManyToOne//cada review assosciada a uma conta
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "albuns_id")
    private Albuns albuns;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;//pesquisar pra decimal(3,2)


    @Lob
    private String comment;

    @CreationTimestamp//indica que o campo é um timestamp
    private Instant createdAt;

    @UpdateTimestamp//indica que o campo é um timestamp
    private Instant updatedAt;



}
