package br.com.zup.casa.codigo.autor;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class AutorModel {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank 
	private String nome;
	
	@NotBlank 
	@JoinColumn(unique = true) 
	@Email
	private String email;
	
	@NotBlank @Size(max=400)
	private String descricao; 
	
	@NotNull 
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	
	@Deprecated
	public AutorModel() {
		 
	}
	
	
public AutorModel(@NotNull String nome, @Email String email, @NotNull @Size(max = 400) String descricao) {
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCadastro = LocalDateTime.now(); 
	}




//getters 
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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	


}
