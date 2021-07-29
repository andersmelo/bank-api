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
import br.com.maida.bankapi.controller.form.TransferenciaForm;
import br.com.maida.bankapi.dto.TransferenciaDto;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.modelo.Usuario;
import br.com.maida.bankapi.repository.UsuarioRepository;
import br.com.maida.bankapi.service.ContaService;

@RestController
@RequestMapping("/accounts/transfer")
public class TransferenciaController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ContaService contaService;

	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TransferenciaDto> cadastrarTransferencia(@RequestBody @Valid TransferenciaForm form,
			UriComponentsBuilder uriBuilder, HttpServletRequest request) {

		String token = recuperarToken(request);
		Conta contaOrigem = contaService.buscaConta(form.getSource_account_number());
		Conta contaDestino = contaService.buscaConta(form.getDestination_account_number());
		contaOrigem.setBalance(contaOrigem.getBalance().subtract(form.getAmount()));
		contaDestino.setBalance(contaDestino.getBalance().add(form.getAmount()));
		
		contaService.editar(contaOrigem);
		contaService.editar(contaDestino);
		Usuario usuario_id = usuarioRepository.findById(tokenService.getIdUsuario(token)).get();
		 
		URI uri = uriBuilder.path("/accounts/transfer").buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(new TransferenciaDto(form.getAmount(), contaOrigem.getNumber(), contaDestino.getNumber(), usuario_id));
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		return token.substring(7, token.length());
	}
}
