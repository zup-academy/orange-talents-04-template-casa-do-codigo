package br.com.zupacademy.ggwadera.casadocodigo.pais;

import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisDTO {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
