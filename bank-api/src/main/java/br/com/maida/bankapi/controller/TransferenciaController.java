package br.com.maida.bankapi.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.maida.bankapi.config.security.TokenService;
import br.com.maida.bankapi.controller.form.TransferenciaForm;
import br.com.maida.bankapi.dto.ContaDto;
import br.com.maida.bankapi.dto.TransferenciaDto;
import br.com.maida.bankapi.modelo.Transferencia;
import br.com.maida.bankapi.service.TransferenciaService;

@RestController
@RequestMapping("/accounts/transfer")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	@Autowired
	private TokenService tokenService;
	
	public ResponseEntity<TransferenciaDto> cadastrarTransferencia(@RequestBody @Valid TransferenciaForm form, UriComponentsBuilder uriBuilder, HttpServletRequest request) {
		String token = recuperarToken(request);
		Transferencia transferencia = transferenciaService.inserir(form, tokenService.getIdUsuario(token) );
		URI uri = uriBuilder.path("/accounts/transfer/{id}").buildAndExpand(transferencia.getId()).toUri();
		return ResponseEntity.created(uri).body(new TransferenciaDto(transferencia));
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return token.substring(7, token.length());
	}
}
