package br.com.maida.bankapi.dto;

import java.math.BigDecimal;

import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.modelo.Usuario;


public class TransferenciaDto {
	
	private BigDecimal amount;
	private Conta source_account_number;
	private Conta destination_account_number;
	private Usuario user_transfer;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public Conta getSource_account_number() {
		return source_account_number;
	}
	public Conta getDestination_account_number() {
		return destination_account_number;
	}
	public Usuario getUser_transfer() {
		return user_transfer;
	}
	
	
}
