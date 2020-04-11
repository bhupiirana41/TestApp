package com.jwt.springsecurityjwt.modal;

public class AuthenticationRequest {
	
	private String userId;
	private String password;
	
	
	public AuthenticationRequest(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public AuthenticationRequest(){
		
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
