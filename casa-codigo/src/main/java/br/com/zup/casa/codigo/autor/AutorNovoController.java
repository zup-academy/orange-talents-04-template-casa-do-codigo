package br.com.zup.casa.codigo.autor;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutorNovoController {
	
	@Autowired
	private  AutorRepository autorRepository; 
		
	//Response = Retornar em caso de 200 
	//Request = Enviar para receber a resposta 
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDtoResponse> cadastrar(@RequestBody @Valid AutorDtoRequest request) {
	
		AutorModel autor = request.toModel(); 
		autorRepository.save(autor); 
		
		return ResponseEntity.ok(new AutorDtoResponse(autor)); 
				
	}
	
}
