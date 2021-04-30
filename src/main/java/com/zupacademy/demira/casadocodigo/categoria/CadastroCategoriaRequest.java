package com.zupacademy.demira.casadocodigo.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class CadastroCategoriaRequest {

    @NotBlank
    private String nome;

    @JsonCreator
    public CadastroCategoriaRequest(@JsonProperty("nome") String nome){

        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
