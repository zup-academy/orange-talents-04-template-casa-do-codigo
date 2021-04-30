package com.zupacademy.demira.casadocodigo.autor;

import com.zupacademy.demira.casadocodigo.compartilhado.VerificaExistenciaNoBanco;

import javax.validation.constraints.*;


public class CadastroAutorRequest {

    private @Email @NotNull @VerificaExistenciaNoBanco(campo = "email", tabela = Autor.class) String email;

    private @NotEmpty @NotBlank String nome;

    private @NotBlank @Size(max = 400) String descricao;

    public CadastroAutorRequest(@NotBlank String nome,
                                @NotBlank @NotEmpty @Email @VerificaExistenciaNoBanco(campo = "email", tabela = Autor.class) String email,
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
