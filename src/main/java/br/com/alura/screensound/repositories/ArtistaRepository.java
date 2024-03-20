package br.com.alura.screensound.repositories;

import br.com.alura.screensound.models.Artista;
import br.com.alura.screensound.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nomeDoArtista%")
    List<Musica> buscarMusicasPorArtista(String nomeDoArtista);
}
