package br.com.zup.casa.codigo.autor;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// DtoResponse é o que retornamos para o usuario 
public class AutorDtoResponse {
	
	
	private Long id;
	private String nome;
	private String email;

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

	 
	// Criar construtores para receber os atributos da classe AutorModel 
	public AutorDtoResponse(AutorModel autorModel) {
		this.id = autorModel.getId(); 
		this.nome = autorModel.getNome(); 
		this.email = autorModel.getEmail();
		
		 
	}
}
