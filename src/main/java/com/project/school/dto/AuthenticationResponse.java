package com.project.school.dto;

public class AuthenticationResponse {
	
	private String jwtToken;

	public AuthenticationResponse(String jwtToken) {
		
		this.jwtToken = jwtToken;
	}


	
}
