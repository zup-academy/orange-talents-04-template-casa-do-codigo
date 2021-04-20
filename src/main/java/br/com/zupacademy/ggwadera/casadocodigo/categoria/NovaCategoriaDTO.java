package br.com.zupacademy.ggwadera.casadocodigo.categoria;

import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
