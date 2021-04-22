package br.com.zupacademy.ggwadera.casadocodigo.util.annotations;

import br.com.zupacademy.ggwadera.casadocodigo.estado.Estado;
import br.com.zupacademy.ggwadera.casadocodigo.estado.EstadoNovoDTO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStateNameValidator implements ConstraintValidator<UniqueStateName, EstadoNovoDTO> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueStateName constraintAnnotation) {
    }

    @Override
    public boolean isValid(EstadoNovoDTO estado, ConstraintValidatorContext context) {
        if (estado == null) return true;
        final List<?> resultList = manager
            .createQuery("select 1 from " + Estado.class.getName() + " where nome = :nome and pais_id = :pais_id")
            .setParameter("nome", estado.getNome())
            .setParameter("pais_id", estado.getPaisId())
            .getResultList();
        final boolean isValid = resultList.isEmpty();
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context
                .buildConstraintViolationWithTemplate("já existe um estado com esse nome no país selecionado")
                .addPropertyNode("nome").addConstraintViolation();
        }
        return isValid;
    }
}
