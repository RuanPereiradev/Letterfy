package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_lists")
public class Lists {

    @Id
    @Column(name = "lists_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne//varias listas pra cada user
    @JoinColumn(name = "user_id")//indica ao criar tabela que o campo user_id é uma chave estrangeira
    private User user;

    private String name;

    @OneToMany(mappedBy = "list")
    private List<ListItem> listItems;



}
