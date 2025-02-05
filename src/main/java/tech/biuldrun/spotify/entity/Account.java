package tech.biuldrun.spotify.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import feign.ResponseMapper;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "account_id")
    private UUID accountId;


    @Column(name = "provider")
    private String provider;

    @Column(name = "providerId")
    private String providerId;

    @OneToMany(mappedBy = "account")
    private List<AccountReview> accountReviews;



    // Relacionamento unidirecional: a conta aponta para o usuário
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    @ToString.Exclude
//🧐 O que é @ToString.Exclude?
//    @ToString.Exclude é uma anotação do Lombok que impede que um campo seja incluído automaticamente no método toString() gerado pela anotação @Data ou @ToString.
    private User user;


    // Log message after entity is loaded from the database
    @PostLoad
    private void onLoad() {
        System.out.println("UserSocialAccount entity loaded: " + this);
    }


}
