package com.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import com.projeto.security.CustomPermission;
import com.projeto.service.PermissionService;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringMethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	
	@Lazy
	@Autowired
	private PermissionService permissionService;
	
	@Override
	protected MethodSecurityExpressionHandler createExpressionHandler() {
	      CustomPermission customPermission = new CustomPermission(permissionService);
	      DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
	      expressionHandler.setPermissionEvaluator(customPermission);
	      return expressionHandler;
	
	}
	
	
	
}
