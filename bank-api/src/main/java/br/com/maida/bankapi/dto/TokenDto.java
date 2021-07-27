package br.com.maida.bankapi.dto;

import br.com.maida.bankapi.modelo.Usuario;

public class TokenDto {
	
	private String name;
	private String email;
	private String token;
	
	
	
	public TokenDto(Usuario usuario, String email, String token) {
		this.name = usuario.getName();
		this.email = email;
		this.token = token;
	
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}

	public String getToken() {
		return token;
	}

	

	

	
}
