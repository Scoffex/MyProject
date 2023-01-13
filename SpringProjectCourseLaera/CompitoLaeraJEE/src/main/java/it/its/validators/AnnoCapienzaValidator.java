package it.its.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;


public class AnnoCapienzaValidator implements ConstraintValidator<AnnoCapienzaCustomConstraint, Object>{
	
	String annoDiProduzione;
	String capienza;
	
	public void initialize(AnnoCapienzaCustomConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		this.annoDiProduzione = constraintAnnotation.annoDiProduzione();
		this.capienza = constraintAnnotation.capienza();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		int anno = (Integer)beanWrapper.getPropertyValue(annoDiProduzione);
		int capienza2 = (Integer)beanWrapper.getPropertyValue(capienza);
		if(anno==1985 && capienza2<69) {
			return false;
		}
		return true;
		
	}

}
