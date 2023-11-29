package org.lab1.dao.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AgeValidator implements ConstraintValidator<Adult, LocalDateTime> {

	@Override
	public boolean isValid(LocalDateTime dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {
		if (dateOfBirth == null) {
			return false;
		}

		LocalDateTime now = LocalDateTime.now();
		LocalDateTime adultAge = now.minusYears(18);

		return dateOfBirth.isBefore(adultAge);
	}
}
