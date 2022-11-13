package it.its.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCustomValidator.class)
public @interface EmailCustomConstraint {

	String message() default "email non valida, inserire un email corretta";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
