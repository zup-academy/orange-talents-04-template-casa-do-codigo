package br.com.zupacademy.ggwadera.casadocodigo.repository;

import br.com.zupacademy.ggwadera.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
