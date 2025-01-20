package tech.biuldrun.spotify.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
@Table(name = "tb_users")
public class User {


    @Getter
    @Id//utiliza o campo como identificador(pk)
    @GeneratedValue(strategy = GenerationType.UUID )// gera o valor automaticamente
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Lob//indica que pode conter um grande volume de texto
    private String bio;

    @CreationTimestamp//indica que o campo é um timestamp
    private Instant createdAt;

    @UpdateTimestamp//indica que o campo é um timestamp
    private Instant updatedAt;

    @OneToOne(mappedBy = "user")//um user pode apenas uma conta
    private Account accounts;

    @OneToMany(mappedBy = "user")
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "user")
    private List<Lists> lists;


    public User(UUID userId, String userName, String email, String password, Instant createdAt, Instant updatedAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


}
