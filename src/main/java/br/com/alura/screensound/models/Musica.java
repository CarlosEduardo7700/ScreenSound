package br.com.alura.screensound.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ss_musicas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String album;
    @ManyToOne
    private Artista artista;

    public Musica(String nome, String album) {
        this.nome = nome;
        this.album = album;
    }
}
