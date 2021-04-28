package com.zupacademy.demira.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastroAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min= 5, max = 300)
    private String descricao;

    public CadastroAutorRequest(@NotBlank String nome,
                                @NotBlank @Email String email,
                                @NotBlank @Size(min= 5, max = 300) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.email, this.nome, this.descricao);
    }

}
