package br.com.zupacademy.ggwadera.casadocodigo.autor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailUnicoAutorValidator implements Validator {

    private final AutorRepository repository;

    public EmailUnicoAutorValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) return;
        final NovoAutorDTO form = (NovoAutorDTO) o;
        if (repository.existsByEmail(form.getEmail())) {
            errors.rejectValue("email", null, "O email informado já existe " + form.getEmail());
        }
    }
}
