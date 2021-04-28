package com.zupacademy.demira.casadocodigo.autor;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/autores")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroAutorResponse> cadastrar(@RequestBody @Valid CadastroAutorRequest form){

        Autor autor = repository.save(form.toModel());

        return ResponseEntity.ok().body(new CadastroAutorResponse(autor));
    }



}
