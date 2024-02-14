package com.example.dto;


public class TokenDTO {

    private String jwtauthtoken;

	public TokenDTO() {
	}

	public TokenDTO(String jwtauthtoken) {
		this.jwtauthtoken = jwtauthtoken;
	}

	public String getJwtauthtoken() {
		return jwtauthtoken;
	}

	public void setJwtauthtoken(String jwtauthtoken) {
		this.jwtauthtoken = jwtauthtoken;
	}

	@Override
	public String toString() {
		return "TokenDTO [jwtauthtoken=" + jwtauthtoken + "]";
	}

	

}
