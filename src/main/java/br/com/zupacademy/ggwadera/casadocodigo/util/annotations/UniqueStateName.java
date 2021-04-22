package br.com.zupacademy.ggwadera.casadocodigo.util.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy = {UniqueStateNameValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueStateName {

    String message() default "já existe um estado com esse nome no país selecionado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
