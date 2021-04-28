package com.zupacademy.demira.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroAutorRequest {

    @Email
    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min= 5, max = 300)
    private String descricao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Autor converteParaModel() {
        return new Autor(this.email, this.nome, this.descricao);
    }

}
