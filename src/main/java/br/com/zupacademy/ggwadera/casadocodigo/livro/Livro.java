package br.com.zupacademy.ggwadera.casadocodigo.livro;

import br.com.zupacademy.ggwadera.casadocodigo.autor.Autor;
import br.com.zupacademy.ggwadera.casadocodigo.categoria.Categoria;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NaturalId
    private String titulo;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String resumo;

    @Column(columnDefinition = "TEXT")
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer numeroDePaginas;

    @NaturalId
    @Column(nullable = false)
    private String isbn;

    private LocalDate dataPublicacao;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    private Livro(Builder builder) {
        this.titulo = builder.titulo;
        this.resumo = builder.resumo;
        this.sumario = builder.sumario;
        this.preco = builder.preco;
        this.numeroDePaginas = builder.numeroDePaginas;
        this.isbn = builder.isbn;
        this.dataPublicacao = builder.dataPublicacao;
        this.categoria = builder.categoria;
        this.autor = builder.autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public static class Builder {
        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer numeroDePaginas;
        private String isbn;
        private LocalDate dataPublicacao;
        private Categoria categoria;
        private Autor autor;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder resumo(String resumo) {
            this.resumo = resumo;
            return this;
        }

        public Builder sumario(String sumario) {
            this.sumario = sumario;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder numeroDePaginas(Integer numeroDePaginas) {
            this.numeroDePaginas = numeroDePaginas;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder dataPublicacao(LocalDate dataPublicacao) {
            this.dataPublicacao = dataPublicacao;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder autor(Autor autor) {
            this.autor = autor;
            return this;
        }

        public Livro build() {
            return new Livro(this);
        }
    }
}
