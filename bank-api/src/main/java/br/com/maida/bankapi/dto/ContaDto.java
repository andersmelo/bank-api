package br.com.maida.bankapi.dto;

import java.math.BigDecimal;

import br.com.maida.bankapi.modelo.Conta;

public class ContaDto {
	private String number;
	private BigDecimal balance;
	private String user;
	
	public ContaDto(Conta conta) {

		this.number = conta.getNumber();
		this.balance = conta.getBalance();
		this.user = conta.getUsuario().getEmail();
	}

	public String getNumber() {
		return number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public String getUser() {
		return user;
	}


}
