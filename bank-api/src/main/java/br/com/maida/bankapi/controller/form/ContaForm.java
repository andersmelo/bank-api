package br.com.maida.bankapi.controller.form;

import java.math.BigDecimal;

import br.com.maida.bankapi.modelo.Conta;



public class ContaForm {
	private Integer number;
	private BigDecimal balance;

	public Integer getNumer() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Conta converter() {
		return new Conta(number, balance);
	}

}
