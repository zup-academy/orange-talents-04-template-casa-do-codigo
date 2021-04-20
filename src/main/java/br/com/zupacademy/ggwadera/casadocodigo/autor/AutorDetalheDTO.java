package br.com.zupacademy.ggwadera.casadocodigo.autor;

public class AutorDetalheDTO {

    private String nome;
    private String descricao;

    public AutorDetalheDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
