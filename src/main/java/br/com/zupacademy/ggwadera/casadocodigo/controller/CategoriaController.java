package br.com.zupacademy.ggwadera.casadocodigo.controller;

import br.com.zupacademy.ggwadera.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.ggwadera.casadocodigo.controller.validator.NomeCategoriaUnicoValidator;
import br.com.zupacademy.ggwadera.casadocodigo.model.Categoria;
import br.com.zupacademy.ggwadera.casadocodigo.repository.CategoriaRepository;
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
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid CategoriaForm form) {
        final Categoria categoria = repository.save(form.toModel());
        return ResponseEntity.ok().build();
    }
}
