package br.com.maida.bankapi.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaldoForm {
	@NotNull 
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String account_number;

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	
}
