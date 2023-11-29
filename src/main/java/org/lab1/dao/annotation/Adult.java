package org.lab1.dao.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)
public @interface Adult {
	String message() default "Person must be at least 18 years old";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
