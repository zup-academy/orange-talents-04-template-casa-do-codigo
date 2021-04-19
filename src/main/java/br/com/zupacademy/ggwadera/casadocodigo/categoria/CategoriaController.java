package br.com.zupacademy.ggwadera.casadocodigo.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;
    private final NomeCategoriaUnicoValidator nomeCategoriaUnicoValidator;

    public CategoriaController(
        CategoriaRepository repository, NomeCategoriaUnicoValidator nomeCategoriaUnicoValidator) {
        this.repository = repository;
        this.nomeCategoriaUnicoValidator = nomeCategoriaUnicoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeCategoriaUnicoValidator);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NovaCategoriaDTO form) {
        final Categoria categoria = repository.save(form.toModel());
        return ResponseEntity.ok().build();
    }
}
