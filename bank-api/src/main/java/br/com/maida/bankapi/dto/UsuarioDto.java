package br.com.maida.bankapi.dto;

import br.com.maida.bankapi.modelo.Usuario;

public class UsuarioDto {
	private String name;
	private String email;
	
	public UsuarioDto(Usuario user) {
		this.name = user.getName();
		this.email = user.getEmail();
		
	}
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	
}
