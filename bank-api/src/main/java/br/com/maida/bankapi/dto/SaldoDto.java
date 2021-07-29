package br.com.maida.bankapi.dto;

import java.math.BigDecimal;

public class SaldoDto {
	private String account_number;
	private BigDecimal balance;
	
	public SaldoDto(String account_number, BigDecimal balance) {
		this.account_number = account_number;
		this.balance = balance;
		
	}

	public String getAccount_number() {
		return account_number;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	
	
	
}
