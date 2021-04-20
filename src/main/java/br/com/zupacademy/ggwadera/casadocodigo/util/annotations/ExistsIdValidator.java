package br.com.zupacademy.ggwadera.casadocodigo.util.annotations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    @PersistenceContext
    private EntityManager manager;

    private Class<?> klass;

    @Override
    public void initialize(ExistsId params) {
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        final Query query = manager.createQuery("select 1 from " + klass.getName() + " where id = :value");
        query.setParameter("value", value);
        return !query.getResultList().isEmpty();
    }
}
