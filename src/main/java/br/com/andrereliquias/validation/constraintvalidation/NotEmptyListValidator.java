package br.com.andrereliquias.validation.constraintvalidation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.andrereliquias.validation.NotEmptyList;

public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

  @Override
  public boolean isValid(List value, ConstraintValidatorContext context) {
    
    return value != null && !value.isEmpty();
  }

  @Override
  public void initialize(NotEmptyList constraintAnnotation) {
    // constraintAnnotation.message()

    // ConstraintValidator.super.initialize(constraintAnnotation);
  }
  
}
