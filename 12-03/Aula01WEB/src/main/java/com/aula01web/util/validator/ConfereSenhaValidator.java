package com.aula01web.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

import com.aula01web.service.exceptions.NegocioException;
import com.aula01web.util.ValidarSenha;

public class ConfereSenhaValidator implements ConstraintValidator<ValidarSenha, Object> {

	
	private String senha;
	private String confirmeSenha;
	
	@Override
	public void initialize(ValidarSenha constraintAnnotation) {
		// TODO Auto-generated method stub
		this.senha = constraintAnnotation.senha();
		this.confirmeSenha = constraintAnnotation.confirmeSenha();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean toReturn = false;
		
		try {
			
			Object atributoSenha = BeanUtils.getProperty(value, this.senha);
			Object atributoConfirmeSenha = BeanUtils.getProperty(value, this.confirmeSenha);
			
			toReturn = oscamposSaoNulo(atributoSenha, atributoConfirmeSenha) || 
					osCamposSaoIguais(atributoSenha, atributoConfirmeSenha);
			
		} catch(Exception e) {
			throw new NegocioException("Erros nos atributos da senha");
		}
		
		if(!toReturn) {
			context.disableDefaultConstraintViolation();
			String mensagem= context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = 
					context.buildConstraintViolationWithTemplate(mensagem);
	
			violationBuilder.addPropertyNode(confirmeSenha).addConstraintViolation();
		}
		return toReturn;
	}

	private boolean osCamposSaoIguais(Object atributoSenha, Object atributoConfirmeSenha) {
		
		return atributoSenha != null && atributoSenha.equals(atributoConfirmeSenha);
	}

	private boolean oscamposSaoNulo(Object atributoSenha, Object atributoConfirmeSenha) {
		// TODO Auto-generated method stub
		return atributoSenha == null && atributoConfirmeSenha ==null;
	}

}
