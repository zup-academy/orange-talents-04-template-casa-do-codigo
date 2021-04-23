package br.com.zup.casa.codigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long> {

	/*List<AutorModel> findByCursoNome(String nome);*/ 

}



	