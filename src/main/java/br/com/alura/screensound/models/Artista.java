package br.com.alura.screensound.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ss_artistas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated
    private TiposArtistas tipos;
    @OneToMany(mappedBy = "artista")
    private List<Musica> musicas = new ArrayList<>();
}
