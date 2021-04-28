package com.zupacademy.demira.casadocodigo.autor;

public class CadastroAutorResponse {

    private String nome;
    private String email;
    private String descricao;

    public CadastroAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }


}
