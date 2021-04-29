package com.zupacademy.demira.casadocodigo.autor;

import javax.validation.constraints.*;


public class CadastroAutorRequest {

    @Email
    @NotNull
    private String email;

    @NotBlank
    @NotEmpty
    private String nome;

    @Size(max = 400)
    @NotBlank
    private String descricao;




    public CadastroAutorRequest(@NotBlank String nome,
                                @NotBlank @NotEmpty @Email String email,
                                @NotBlank @Size(min= 5, max = 400) String descricao) {

        if (nome == null || email == null || email == null || nome == "" ||
            email == ""){
            throw new IllegalArgumentException();
        }

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }


    public String getEmail() {
        return this.email;
    }
}
