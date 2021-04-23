package br.com.zup.casa.codigo.autor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//DtoRequest é os atributos obrigatorios que irão ser informados na AutorModel 
//DtoRequest exige as anotações ( porque precisa validar as informações que vai receber antes de enviar pro banco de dados)

public class AutorDtoRequest {

	@NotBlank 
	private String nome;
	
	@NotBlank 
	@JoinColumn(unique = true) 
	@Email
	private String email;
	
	@NotBlank  @Size(min=20, max=400)
	private String descricao; 
	
	
	public AutorDtoRequest(String nome, String email, String descricao) {
	
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		
	}

	
 // getters 
	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getDescricao() {
		return descricao;
	}

	 
	public AutorModel toModel() {
		return new AutorModel(this.nome, this.email, this.descricao); 
	}

}
