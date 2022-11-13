package it.its.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateCustomValidator implements ConstraintValidator<DateCustomConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(value, formatter);
		long days = ChronoUnit.DAYS.between(localDate, LocalDate.now());
		if(days >= 6574) {
			return true;
		}else {
			return false;
		}
	}

}
