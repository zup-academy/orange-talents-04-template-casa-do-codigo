package com.zupacademy.demira.casadocodigo.autor;

import javax.validation.constraints.*;


public class CadastroAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public CadastroAutorRequest(@NotBlank String nome,
                            @NotBlank @Email String email,
                            @NotBlank @Size(max = 400) String descricao) {
        super();
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome,this.email,this.descricao);
    }

    public String getEmail() {
        return this.email;
    }
}
