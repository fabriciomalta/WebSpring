package com.projeto.model;

import java.io.Serializable;

public class Login implements Serializable{


	private static final long serialVersionUID = -6877627940812668237L;
	private String email;
	private String password;
	
	
	public Login() {
	}

	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
