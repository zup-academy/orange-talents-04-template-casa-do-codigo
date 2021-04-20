package br.com.zupacademy.ggwadera.casadocodigo.livro;

import br.com.zupacademy.ggwadera.casadocodigo.autor.Autor;
import br.com.zupacademy.ggwadera.casadocodigo.categoria.Categoria;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.Exists;
import br.com.zupacademy.ggwadera.casadocodigo.util.annotations.UniqueValue;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroDTO {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @DecimalMin(value = "20")
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroDePaginas;

    @NotBlank
    @ISBN
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @FutureOrPresent
    private LocalDate dataPublicacao;

    @NotNull
    @Exists(domainClass = Categoria.class)
    private Long categoriaId;

    @NotNull
    @Exists(domainClass = Autor.class)
    private Long autorId;

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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public Livro toModel(EntityManager manager) {
        final Categoria categoria = manager.find(Categoria.class, this.categoriaId);
        final Autor autor = manager.find(Autor.class, this.autorId);
        return new Livro.Builder().titulo(this.titulo)
            .resumo(this.resumo)
            .sumario(this.sumario)
            .preco(this.preco)
            .numeroDePaginas(this.numeroDePaginas)
            .isbn(this.isbn)
            .dataPublicacao(this.dataPublicacao)
            .categoria(categoria)
            .autor(autor)
            .build();
    }
}
