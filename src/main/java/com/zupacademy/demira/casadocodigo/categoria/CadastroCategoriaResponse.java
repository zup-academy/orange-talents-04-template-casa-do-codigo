package com.zupacademy.demira.casadocodigo.categoria;

import com.zupacademy.demira.casadocodigo.autor.Autor;

public class CadastroCategoriaResponse {

    private String nome;

    public CadastroCategoriaResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
