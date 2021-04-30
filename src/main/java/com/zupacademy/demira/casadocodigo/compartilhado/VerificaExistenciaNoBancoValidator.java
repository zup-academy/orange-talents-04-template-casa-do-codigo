package com.zupacademy.demira.casadocodigo.compartilhado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerificaExistenciaNoBancoValidator
        implements ConstraintValidator<VerificaExistenciaNoBanco, Object> {

    private String campoASerPesquisado;
    private Class<?> tabela;

    @PersistenceContext
    private EntityManager entityManager;

    public VerificaExistenciaNoBancoValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(VerificaExistenciaNoBanco constraintAnnotation) {
        this.tabela = constraintAnnotation.tabela();
        this.campoASerPesquisado = constraintAnnotation.campo();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Boolean valorJaExiste = entityManager.createQuery("select count(t) > 0 from "+ tabela +
                " t  where " + campoASerPesquisado + " :valor", Boolean.class)
                .setParameter("value", value)
                .getSingleResult();

        return valorJaExiste;

    }
}
