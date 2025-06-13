package br.edu.utfpr.td.tsi.trabalho1.constraint.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CpfUnicoValidator.class)
public @interface CpfUnico {
	
	String message() default "O CPF deve ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
