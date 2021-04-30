package com.zupacademy.demira.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private @NotBlank String nome;

    @Column(nullable = false, unique = true)
    private @NotBlank @Email String email;

    @Column(nullable = false)
    private @NotBlank @Size(max = 400) String descricao;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now(ZoneOffset.UTC);

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome,
                 @NotBlank @Email String email,
                 @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }



}
