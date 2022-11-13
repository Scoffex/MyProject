package it.its.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordCustomValidator implements ConstraintValidator<PasswordCustomConstraint, String> {
	/*
	 * Password must contain at least one digit [0-9]. Password must contain at
	 * least one lowercase Latin character [a-z]. Password must contain at least one
	 * uppercase Latin character [A-Z]. Password must contain at least one special
	 * character like ! @ # & ( ). Password must contain a length of at least 8
	 * characters and a maximum of 20 characters.
	 */
	private String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
	private Pattern pattern = Pattern.compile(regex);

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
