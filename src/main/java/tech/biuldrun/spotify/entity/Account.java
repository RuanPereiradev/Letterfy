package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "tb_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID acountId;

    @OneToOne//apenas uma conta pra cada user
    @JoinColumn(name = "user_id")//indica ao criar tabela que o campo user_id é uma chave estrangeira
    private User user;

    @Column(name = "description")
    private String description;

    @Column(name = "provider")
    private String provider;


}
