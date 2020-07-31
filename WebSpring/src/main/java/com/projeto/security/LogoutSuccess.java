package com.projeto.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class LogoutSuccess implements LogoutSuccessHandler {

	private static final String SESSION_COOKIE_PATH = "/";
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		
		final HttpSession session = request.getSession();
		
		
		if (response.isCommitted()) {
			return;
		}
		
		if (request.isRequestedSessionIdValid()) {
			request.changeSessionId();
		}
		
		if ( (authentication != null ) && ( authentication.getDetails() != null) ) {
			try {
				session.removeAttribute("user");
				session.invalidate();
			} catch( Exception e) {
				e.printStackTrace();
			}
		}
   		
	    limparCookies(request, response);	
		response.setStatus(HttpServletResponse.SC_OK);
		request.getRequestDispatcher(String.format("/?mensagem=%s","Logout efetuado com sucesso!")).forward(request, response);
		
	}
	
	
	
	private void limparCookies(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if ( (cookies == null ) || ( cookies.length < 1) ) {
			return;
		}
		
		for (Cookie cookie : cookies ) {
			cookie.setMaxAge(0);
			cookie.setPath(SESSION_COOKIE_PATH);
			cookie.setValue(null);
			response.addCookie(cookie);
		}
	}
	
	
	
	
	
	
	
	
	
	

}
