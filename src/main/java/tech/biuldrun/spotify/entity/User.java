package tech.biuldrun.spotify.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Importante para a serialização
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_users")
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name")
    private String userName;

    private String email;

    @Column(name = "password")
    private String password;

    private UserRole role;

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



    public User(UUID userId, String userName, String email,  String encryptedPassword,String password, Instant createdAt, Instant updatedAt, UserRole role ) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.password = encryptedPassword;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role==UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }


    public String getUserName() {
        return userName;
    }
}
