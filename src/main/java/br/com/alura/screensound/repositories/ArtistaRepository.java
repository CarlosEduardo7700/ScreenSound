package br.com.alura.screensound.repositories;

import br.com.alura.screensound.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
