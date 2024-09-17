package com.oc.medilabo.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = BirthDateValidator.class)
@Documented
public @interface BirthDate {

    String message() default "Invalid birthdate, please use the AAAA-MM-DD format.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
