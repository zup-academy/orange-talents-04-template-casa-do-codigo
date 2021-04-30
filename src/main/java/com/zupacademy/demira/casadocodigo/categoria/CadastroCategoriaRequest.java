package com.zupacademy.demira.casadocodigo.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zupacademy.demira.casadocodigo.compartilhado.VerificaExistenciaNoBanco;

import javax.validation.constraints.*;

public class CadastroCategoriaRequest {


    private @NotBlank @VerificaExistenciaNoBanco(campo = "nome", tabela = Categoria.class) String nome;

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
