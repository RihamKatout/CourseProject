package com.exalt.training.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeValidator.Class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "Spring";

    // define default error message
    public String message() default "I don't hate errors :)";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    // provides custom details about validation failure (severity level, error code ...)
    public Class<? extends Payload>[] payload() default {};
}