package tech.biuldrun.spotify.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Importante para a serialização
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Reference;


import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Lob
    private String bio;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;



    // Relacionamento com a classe Account

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE , orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude // ⚠️ Isso impede o loop
    private Account account;


    public User(UUID userId, String userName, String email, String password, Instant createdAt, Instant updatedAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
