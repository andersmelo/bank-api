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

import br.com.maida.bankapi.config.security.TokenService;
import br.com.maida.bankapi.controller.form.ContaForm;
import br.com.maida.bankapi.dto.ContaDto;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.repository.ContaRepository;
import br.com.maida.bankapi.service.ContaService;

@RestController
@RequestMapping("/accounts")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@Autowired 
	ContaRepository contaRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<ContaDto> cadastrarConta(@RequestBody @Valid ContaForm form, UriComponentsBuilder uriBuilder, HttpServletRequest request) {
		String token = recuperarToken(request);
		Conta conta = contaService.save(form, tokenService.getIdUsuario(token) );
		URI uri = uriBuilder.path("/accounts/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContaDto(conta));
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return token.substring(7, token.length());
	}
}
