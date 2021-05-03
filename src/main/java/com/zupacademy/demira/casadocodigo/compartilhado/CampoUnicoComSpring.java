package com.zupacademy.demira.casadocodigo.compartilhado;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.lang.reflect.Field;
import java.util.function.Function;

public class CampoUnicoComSpring<T, P> implements Validator {

    private String campo;
    private Class<? extends T> classeASerValidada;
    private Function<P,Boolean> metodoDeConsultarBanco;

    public CampoUnicoComSpring(String campo, Class<? extends T> classeASerValidada, Function<P, Boolean> metodoDeConsultarBanco) {
        this.campo = campo;
        this.classeASerValidada = classeASerValidada;
        this.metodoDeConsultarBanco = metodoDeConsultarBanco;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return this.classeASerValidada.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        try {
            Field declaredField = classeASerValidada.getDeclaredField(this.campo);
            declaredField.setAccessible(true);
            Object valorASerPesquisado = declaredField.get(target);
            Boolean existeNoBanco = metodoDeConsultarBanco.apply((P) valorASerPesquisado);

            if (existeNoBanco){
                errors.rejectValue(campo, "campoUnico");
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
