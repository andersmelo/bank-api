package br.com.maida.bankapi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.maida.bankapi.controller.form.ContaForm;
import br.com.maida.bankapi.dto.ContaDto;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.repository.ContaRepository;

@RestController
@RequestMapping("/accounts")
public class ContaController {
	
	@Autowired 
	ContaRepository contaRepository;
	
	@PostMapping
	public ResponseEntity<ContaDto> cadastrarConta(@RequestBody ContaForm form, UriComponentsBuilder uriBuilder) {
		Conta conta = form.converter();
		contaRepository.save(conta);
		
		URI uri = uriBuilder.path("/accounts/{id}").buildAndExpand(conta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ContaDto(conta));
	}
}
