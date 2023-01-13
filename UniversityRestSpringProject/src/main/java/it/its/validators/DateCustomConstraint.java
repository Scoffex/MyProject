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
@Constraint(validatedBy = DateCustomValidator.class)
public @interface DateCustomConstraint {

	String message() default "Devi essere maggiorenne per poterti iscrivere, data invalida";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	

}
