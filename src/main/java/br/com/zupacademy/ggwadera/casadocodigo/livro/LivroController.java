package br.com.zupacademy.ggwadera.casadocodigo.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheDTO> buscar(@PathVariable Long id) {
        final Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Não foi encontrado um livro com o id " + id));
        return ResponseEntity.ok(new LivroDetalheDTO(livro));
    }
}
