package com.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projeto.security.LoginAuthenticationProvider;
import com.projeto.security.LoginFailureHandler;
import com.projeto.security.LoginSuccessHandler;
import com.projeto.security.LogoutSuccess;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private LoginAuthenticationProvider loginAuthenticationProvider;

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Autowired
	private LoginFailureHandler loginFailureHandler;

	@Autowired
	private LogoutSuccess logoutSuccess;

	@Autowired
	private PersistentTokenRepository persistentTokenRepository;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(loginAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/usuario/**").hasAnyRole("ADMINISTRADOR","USUARIO")
			.anyRequest().authenticated();

		http.formLogin()
			.loginPage("/login")
			.usernameParameter("email")
			.passwordParameter("password")
			.successHandler(loginSuccessHandler)
			.failureHandler(loginFailureHandler)
			.permitAll();

		http.logout()
			.logoutSuccessHandler(logoutSuccess)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll();

		http.sessionManagement()
			.invalidSessionUrl("/?mensagem=true")
			.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false)
			.expiredUrl("/?mensagem=true")
			.sessionRegistry(sessionRegistry()).and()
			.sessionFixation()
			.none();

		http.exceptionHandling()
			.accessDeniedPage("/403");
		
		http.rememberMe()
			.rememberMeCookieName("LEMBRARID")
			.rememberMeParameter("checkRememberMe")
			.tokenValiditySeconds(diasParaSegundo(12,1))
			.tokenRepository(persistentTokenRepository);
		
		http.csrf();

	}

	private int diasParaSegundo(int horas, int dias) {
		return (60*60*horas)*dias;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		   .antMatchers("/resources/**");
	}
	
	@Bean
	public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
		PersistentTokenBasedRememberMeServices persistentTokenBasedService = new PersistentTokenBasedRememberMeServices("LEMBRARID", userDetailsService, persistentTokenRepository);
		persistentTokenBasedService.setAlwaysRemember(true);
		return persistentTokenBasedService;
		
	}
	
	

}
