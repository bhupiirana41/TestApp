package com.jwt.springsecurityjwt.modal;

public class AuthenticationResponse {

	private String jwt;
	
	

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public AuthenticationResponse(){
		
	}

	public String getJwt() {
		return jwt;
	}
	
	
}
