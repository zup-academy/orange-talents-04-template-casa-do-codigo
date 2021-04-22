package br.com.zupacademy.ggwadera.casadocodigo.estado;

import br.com.zupacademy.ggwadera.casadocodigo.pais.Pais;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.ExistsId;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueStateName;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueStateName
public class EstadoNovoDTO {

    @NotBlank
    private String nome;

    @NotNull
    @ExistsId(domainClass = Pais.class)
    private Long paisId;

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Estado toModel(EntityManager manager) {
        final Pais pais = manager.find(Pais.class, paisId);
        return new Estado(nome, pais);
    }
}
