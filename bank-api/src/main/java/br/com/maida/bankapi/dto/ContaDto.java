package br.com.maida.bankapi.dto;

import java.math.BigDecimal;

import br.com.maida.bankapi.modelo.Conta;

public class ContaDto {
	private Integer number;
	private BigDecimal balance;

	public ContaDto(Conta conta) {

		this.number = conta.getNumber();
		this.balance = conta.getBalance();
	}

	public Integer getNumber() {
		return number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

}
