package br.com.zupacademy.ggwadera.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;
    private final EmailUnicoAutorValidator emailUnicoAutorValidator;

    public AutorController(
        AutorRepository repository, EmailUnicoAutorValidator emailUnicoAutorValidator) {
        this.repository = repository;
        this.emailUnicoAutorValidator = emailUnicoAutorValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailUnicoAutorValidator);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid NovoAutorDTO form) {
        final Autor autor = repository.save(form.toModel());
        return ResponseEntity.ok().build();
    }
}
