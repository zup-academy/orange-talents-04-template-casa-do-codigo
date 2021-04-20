package br.com.zupacademy.ggwadera.casadocodigo.livro;

import br.com.zupacademy.ggwadera.casadocodigo.autor.AutorDetalheDTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheDTO {

    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer numeroDePaginas;
    private final String isbn;
    private final String categoria;
    private final LocalDate dataPublicacao;
    private final AutorDetalheDTO autor;

    public LivroDetalheDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.categoria = livro.getCategoria().getNome();
        this.dataPublicacao = livro.getDataPublicacao();
        this.autor = new AutorDetalheDTO(livro.getAutor());
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

    public String getCategoria() {
        return categoria;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public AutorDetalheDTO getAutor() {
        return autor;
    }
}
