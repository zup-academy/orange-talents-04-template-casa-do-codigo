package br.com.zup.casa.codigo.autor;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PoribeEmailDuplicadoAutorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		 
		return AutorDtoRequest.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorDtoRequest request = (AutorDtoRequest) target; 
		
	}

	

}
