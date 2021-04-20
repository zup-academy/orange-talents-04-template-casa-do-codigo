package br.com.zupacademy.ggwadera.casadocodigo.livro;

public class LivroItemListaDTO {

    private final Long id;
    private final String titulo;

    public LivroItemListaDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
