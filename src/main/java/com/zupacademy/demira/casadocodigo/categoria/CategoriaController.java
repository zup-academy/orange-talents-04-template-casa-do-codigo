package com.zupacademy.demira.casadocodigo.categoria;

import com.zupacademy.demira.casadocodigo.autor.ProibeEmailDuplicadoAutorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

        @Autowired
        private CategoriaRepository repository;

        @PostMapping
        @Transactional
        public ResponseEntity<CadastroCategoriaResponse> cadastrar(@RequestBody @Valid CadastroCategoriaRequest form,
                                                               UriComponentsBuilder uriBuilder){

            if (repository.existsByNome(form.getNome())){
                return ResponseEntity.badRequest().build();
            }

            Categoria categoria = repository.save(form.toModel());

            URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
            return ResponseEntity.created(uri).body(new CadastroCategoriaResponse(categoria));

        }



    }
