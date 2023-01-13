package it.its.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AnnoCapienzaValidator.class)
public @interface AnnoCapienzaCustomConstraint {
	String message() default "{annoDiProduzione} {capienza} la validazione e' fallita";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String annoDiProduzione();
    String capienza();

}
