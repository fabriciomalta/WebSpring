package com.projeto.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.apache.commons.beanutils.BeanUtils;

import com.projeto.util.ValidarSenha;

public class ValidarSenhaValidator implements ConstraintValidator<ValidarSenha, Object> {

	private String senha_usuario;
	private String confirmeSenha_usuario;
	
	@Override
	public void initialize(ValidarSenha constraintAnnotation) {
		this.senha_usuario = constraintAnnotation.senha_usuario();
		this.confirmeSenha_usuario = constraintAnnotation.confirmeSenha_usuario();
	}
	
	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		boolean valido = false;
		try {
			Object valorAtributo = BeanUtils.getProperty(object, this.senha_usuario);
			Object valorAtributoConfirmacao = BeanUtils.getProperty(object, this.confirmeSenha_usuario);
			
			valido = ambosSaoNull(valorAtributo, valorAtributoConfirmacao) || ambosSaoIguais(valorAtributo, valorAtributoConfirmacao);
		} catch (Exception e) {
			throw new RuntimeException("Erro recuperando valores dos atributos", e);
		}
		
		if (!valido) {
			context.disableDefaultConstraintViolation();
			String mensagem = context.getDefaultConstraintMessageTemplate();
			ConstraintViolationBuilder violationBuilder = context.buildConstraintViolationWithTemplate(mensagem);
			violationBuilder.addPropertyNode(confirmeSenha_usuario).addConstraintViolation();
		}
		
		return valido;
	}

	private boolean ambosSaoIguais(Object valorAtributo, Object valorAtributoConfirmacao) {
		return valorAtributo != null && valorAtributo.equals(valorAtributoConfirmacao);
	}

	private boolean ambosSaoNull(Object valorAtributo, Object valorAtributoConfirmacao) {
		return valorAtributo == null && valorAtributoConfirmacao == null;
	}
}
