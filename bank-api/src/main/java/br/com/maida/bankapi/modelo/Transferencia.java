package br.com.maida.bankapi.modelo;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transferencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal amount;
	
	@ManyToOne
	private Usuario user;
	
	@ManyToOne
	@JoinColumn(name = "source_account_number_id")
	private Conta source_account_number;
	
	@ManyToOne
	@JoinColumn(name = "destination_account_number_id")
	private Conta destination_account_number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Conta getSource_account_number() {
		return source_account_number;
	}

	public void setSource_account_number(Conta source_account_number) {
		this.source_account_number = source_account_number;
	}

	public Conta getDestination_account_number() {
		return destination_account_number;
	}

	public void setDestination_account_number(Conta destination_account_number) {
		this.destination_account_number = destination_account_number;
	}
	
	
	
	
	
}
