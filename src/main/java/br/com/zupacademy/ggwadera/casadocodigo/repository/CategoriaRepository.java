package br.com.zupacademy.ggwadera.casadocodigo.repository;

import br.com.zupacademy.ggwadera.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    boolean existsByNome(String nome);

}
