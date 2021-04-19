package br.com.zupacademy.ggwadera.casadocodigo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime instante;

    /**
     * Somente para uso do Hibernate
     */
    @Deprecated
    public Autor() {
    }

    public Autor(String email, String nome, String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", email='" + email + '\'' + ", nome='" + nome + '\'' + ", descricao='" + descricao + '\'' + ", instante=" + instante + '}';
    }
}
