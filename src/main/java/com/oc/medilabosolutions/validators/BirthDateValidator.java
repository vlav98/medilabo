package com.oc.medilabosolutions.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDate, String> {
    private static final String BIRTHDATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    @Override
    public boolean isValid(String birthdate, ConstraintValidatorContext constraintValidatorContext) {
        return birthdate != null && birthdate.matches(BIRTHDATE_PATTERN);
    }
}
