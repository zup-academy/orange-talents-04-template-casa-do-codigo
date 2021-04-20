package br.com.zupacademy.ggwadera.casadocodigo.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;
    @PersistenceContext
    private EntityManager manager;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NovoLivroDTO form) {
        final Livro livro = livroRepository.save(form.toModel(manager));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<LivroItemListaDTO>> listar(Pageable pageable) {
        final Page<LivroItemListaDTO> livros = livroRepository.findAll(pageable).map(LivroItemListaDTO::new);
        return ResponseEntity.ok(livros);
    }
}
