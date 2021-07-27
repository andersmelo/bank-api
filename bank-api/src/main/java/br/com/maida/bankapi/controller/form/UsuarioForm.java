package br.com.maida.bankapi.controller.form;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.maida.bankapi.modelo.Usuario;

public class UsuarioForm {
	@NotNull 
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email(message = "Email inválido!") 
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Size(min = 6, max = 12, message = "Deve ter entre 6 a 12 caracteres")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Usuario converter() {
		return new Usuario(name, email, new BCryptPasswordEncoder().encode(password));
	}

}
