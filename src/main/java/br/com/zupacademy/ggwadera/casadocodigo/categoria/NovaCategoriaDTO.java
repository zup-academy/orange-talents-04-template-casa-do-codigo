package br.com.zupacademy.ggwadera.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDTO {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
