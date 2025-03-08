package tech.biuldrun.spotify.entity;

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
@Entity(name = "users")
@Table(name = "tb_user")
@Getter
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;


    @Column(name = "user_name")
    private String userName;

    private String login;

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


    @OneToMany(mappedBy = "user")
    private List<UserReview> userReviews;


    public User(UUID uuid, String login, String password, Instant now, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }



    // Métodos da interface UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role==UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
