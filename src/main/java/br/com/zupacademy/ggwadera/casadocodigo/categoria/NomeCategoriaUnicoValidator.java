package br.com.zupacademy.ggwadera.casadocodigo.categoria;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class NomeCategoriaUnicoValidator implements Validator {

    private final CategoriaRepository repository;

    public NomeCategoriaUnicoValidator(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) return;
        final NovaCategoriaDTO form = (NovaCategoriaDTO) o;
        if (repository.existsByNome(form.getNome())) {
            errors.rejectValue("nome", null, "O nome informado já existe: " + form.getNome());
        }
    }
}
