package br.com.maida.bankapi.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.maida.bankapi.controller.form.SaldoForm;
import br.com.maida.bankapi.dto.SaldoDto;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.service.ContaService;

@RestController
@RequestMapping("/accounts/balance")
public class SaldoController {
		
	@Autowired
	private ContaService contaService;


	@PostMapping
	public ResponseEntity<SaldoDto> ExibirSaldo(@RequestBody @Valid SaldoForm form, UriComponentsBuilder uriBuilder,
			HttpServletRequest request) {
		
		Conta conta = contaService.saldo(form.getAccount_number());
		URI uri = uriBuilder.path("/accounts/balance").buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(new SaldoDto(conta.getNumber(), conta.getBalance()));
	}

}
