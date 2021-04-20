package br.com.zupacademy.ggwadera.casadocodigo.livro;

public class LivroDTO {

    private final Long id;
    private final String titulo;

    public LivroDTO(Livro livro) {
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
