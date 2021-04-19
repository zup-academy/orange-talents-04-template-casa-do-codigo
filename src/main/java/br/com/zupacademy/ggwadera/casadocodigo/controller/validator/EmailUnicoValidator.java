package br.com.zupacademy.ggwadera.casadocodigo.controller.validator;

import br.com.zupacademy.ggwadera.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.ggwadera.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailUnicoValidator implements Validator {

    private final AutorRepository repository;

    public EmailUnicoValidator(AutorRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) return;
        final AutorForm form = (AutorForm) o;
        if (repository.existsByEmail(form.getEmail())) {
            errors.rejectValue("email", null, "O email informado já existe " + form.getEmail());
        }
    }
}
