package tech.biuldrun.spotify.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "tb_songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "song_id")
    private UUID songId;

    @Column(name = "spotify_id", nullable = false, unique = true)
    private String spotifyId;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY)
    @JsonManagedReference
    @ToString.Exclude//se tirar da merda
    private List<Reviews> reviews;

    public Song(UUID songId, String spotifyId, String name, String duration) {
        this.songId = songId;
        this.spotifyId = spotifyId;
        this.name = name;
        this.duration = duration;
    }

    @PostLoad
    private void onLoad() {
        System.out.println("Song entity loaded: " + this);
    }
}
