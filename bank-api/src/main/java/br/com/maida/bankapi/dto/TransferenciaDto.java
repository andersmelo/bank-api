package br.com.maida.bankapi.dto;

import java.math.BigDecimal;

import br.com.maida.bankapi.modelo.Usuario;


public class TransferenciaDto {
	
	private BigDecimal amount;
	private String source_account_number;
	private String destination_account_number;
	private Usuario user_transfer;
	
	public TransferenciaDto(BigDecimal amount, String source_account_number, String destination_account_number, Usuario user_transfer) {
		this.amount = amount;
		this.source_account_number = source_account_number;
		this.destination_account_number = destination_account_number;
		this.user_transfer = user_transfer;
		
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getSource_account_number() {
		return source_account_number;
	}
	public String getDestination_account_number() {
		return destination_account_number;
	}
	public Usuario getUser_transfer() {
		return user_transfer;
	}
	
	
}
