package com.zupacademy.demira.casadocodigo.categoria;

import com.zupacademy.demira.casadocodigo.autor.CadastroAutorRequest;
import com.zupacademy.demira.casadocodigo.compartilhado.CampoUnicoComSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

        @Autowired
        private CategoriaRepository repository;

        @InitBinder
        public void validacao(WebDataBinder binder){
            CampoUnicoComSpring<CadastroCategoriaRequest, String> validadorNomeUnico =
                    new CampoUnicoComSpring<>("nome", CadastroCategoriaRequest.class,
                    repository::existsByNome);
            binder.addValidators(validadorNomeUnico);
        }

        @PostMapping
        @Transactional
        public ResponseEntity<CadastroCategoriaResponse> cadastrar(@RequestBody @Valid CadastroCategoriaRequest form,
                                                               UriComponentsBuilder uriBuilder){
            Categoria categoria = repository.save(form.toModel());

            URI uri = uriBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
            return ResponseEntity.created(uri).body(new CadastroCategoriaResponse(categoria));

        }
    }
