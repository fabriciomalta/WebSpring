
package com.aula01web.util;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

import com.aula01web.util.validator.ConfereSenhaValidator;

@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, ANNOTATION_TYPE })
@Constraint(validatedBy = {ConfereSenhaValidator.class})
public @interface ValidarSenha {

	@OverridesAttribute(constraint = Pattern.class, name="message")
		String message() default "Senhas não conferem";
		
	Class<?>[] groups() default{};
	
	Class <? extends Payload>[] payload() default{};
		
	String senha();
	String confirmeSenha();
	
	
}