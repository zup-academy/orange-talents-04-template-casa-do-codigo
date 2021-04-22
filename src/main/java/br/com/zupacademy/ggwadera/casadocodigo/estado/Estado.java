package br.com.zupacademy.ggwadera.casadocodigo.estado;

import br.com.zupacademy.ggwadera.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"pais_id", "nome"})
)
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false)
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
