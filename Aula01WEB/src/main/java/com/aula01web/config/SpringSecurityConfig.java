package com.aula01web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		String password = passwordEncoder().encode("123456");
		try {
			
			//auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
			auth.inMemoryAuthentication().withUser("admin").password(password).roles("ADMINISTRADOR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
				http.authorizeRequests().antMatchers("/resources/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers("/static/**").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated();
				
	http.formLogin()
		.loginPage("/login")
		.usernameParameter("email")
		.passwordParameter("senha")
		.defaultSuccessUrl("/home",true)
		.failureUrl("/login")
		.permitAll();
						
	
	http.csrf();
	}
	
 @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources**");
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
