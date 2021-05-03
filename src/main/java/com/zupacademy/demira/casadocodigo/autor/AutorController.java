package com.zupacademy.demira.casadocodigo.autor;

import com.zupacademy.demira.casadocodigo.categoria.CadastroCategoriaRequest;
import com.zupacademy.demira.casadocodigo.compartilhado.CampoUnicoComSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @InitBinder
    public void validacao(WebDataBinder binder){
        CampoUnicoComSpring<CadastroAutorRequest, String> validadorEmailUnico =
                new CampoUnicoComSpring<>("email", CadastroAutorRequest.class,
                        repository::existsByEmail);
        binder.addValidators(validadorEmailUnico);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CadastroAutorResponse> cadastrar(@RequestBody @Valid CadastroAutorRequest form,
                                                            UriComponentsBuilder uriBuilder){
        Autor autor = repository.save(form.toModel());

        URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new CadastroAutorResponse(autor));
    }



}
