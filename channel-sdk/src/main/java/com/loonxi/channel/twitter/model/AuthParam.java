package com.loonxi.channel.twitter.model;

import java.io.Serializable;

public class AuthParam implements Serializable{

	private String authUrl;
	private String token;
    private String tokenSecret;
	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenSecret() {
		return tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}
    
}
