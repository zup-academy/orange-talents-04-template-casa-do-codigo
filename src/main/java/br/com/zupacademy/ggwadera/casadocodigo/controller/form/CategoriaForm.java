package br.com.zupacademy.ggwadera.casadocodigo.controller.form;

import br.com.zupacademy.ggwadera.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
