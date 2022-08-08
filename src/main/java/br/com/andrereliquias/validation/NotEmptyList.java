package br.com.andrereliquias.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.andrereliquias.validation.constraintvalidation.NotEmptyListValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //diz onde vamos colocar essa anotation
@Constraint(validatedBy = NotEmptyListValidator.class) //diz q essa anotation e trxo de validacao
public @interface NotEmptyList {

  String message() default "A lista nao pode ser vazia.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
