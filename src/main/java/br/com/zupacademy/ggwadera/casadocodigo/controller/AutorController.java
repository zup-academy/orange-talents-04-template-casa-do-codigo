package br.com.zupacademy.ggwadera.casadocodigo.controller;

import br.com.zupacademy.ggwadera.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.ggwadera.casadocodigo.controller.validator.EmailUnicoValidator;
import br.com.zupacademy.ggwadera.casadocodigo.model.Autor;
import br.com.zupacademy.ggwadera.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;
    private final EmailUnicoValidator emailUnicoValidator;

    public AutorController(
        AutorRepository repository, EmailUnicoValidator emailUnicoValidator) {
        this.repository = repository;
        this.emailUnicoValidator = emailUnicoValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoValidator);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AutorForm form) {
        final Autor autor = repository.save(form.toModel());
        return ResponseEntity.ok().build();
    }
}
