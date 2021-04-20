package br.com.zupacademy.ggwadera.casadocodigo.autor;

import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoAutorDTO {

    @Email
    @NotBlank
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @Length(max = 400)
    @NotBlank
    private String descricao;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.email, this.nome, this.descricao);
    }
}
