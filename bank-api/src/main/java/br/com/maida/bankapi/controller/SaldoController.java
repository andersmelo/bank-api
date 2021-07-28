package br.com.maida.bankapi.controller;
/*
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

import br.com.maida.bankapi.config.security.TokenService;
import br.com.maida.bankapi.controller.form.SaldoForm;
import br.com.maida.bankapi.dto.SaldoDto;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.service.ContaService;

@RestController
@RequestMapping("/accounts/balance")
public class SaldoController {
	/*
	@Autowired
	private ContaService saldoService;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<SaldoDto> ExibirSaldo(@RequestBody @Valid SaldoForm form, UriComponentsBuilder uriBuilder,
			HttpServletRequest request) {
		String token = recuperarToken(request);
		Conta conta = saldoService.saldo(form, tokenService.getIdUsuario(token) );
		URI uri = uriBuilder.path("/accounts/balance/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(new SaldoDto(conta));
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return token.substring(7, token.length());
	}
}*/
