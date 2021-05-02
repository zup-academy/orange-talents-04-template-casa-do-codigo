package com.zupacademy.demira.casadocodigo.categoria;

import javax.validation.constraints.*;

public class CadastroCategoriaRequest {


    private
    @NotBlank String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
