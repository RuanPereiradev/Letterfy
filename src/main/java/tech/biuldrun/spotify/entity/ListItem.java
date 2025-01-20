package tech.biuldrun.spotify.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_list_item")
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private Lists list;

    @ManyToOne
    @JoinColumn(name = "album_id",nullable = false)
    private Albuns album;


}
