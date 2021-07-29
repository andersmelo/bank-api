package br.com.maida.bankapi.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.modelo.Usuario;


public class ContaForm {
	@NotNull 
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String number;
	
	@NotNull 
	@Digits(integer = 10, fraction = 2, message = "O valor não está de acordo com o padrão!")
	private BigDecimal balance;
	private Usuario user;
	
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Conta converter(Usuario user) {
		
		return new Conta(number, balance, user);
	}


}
