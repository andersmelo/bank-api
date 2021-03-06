package br.com.maida.bankapi.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maida.bankapi.controller.form.ContaForm;
import br.com.maida.bankapi.modelo.Conta;
import br.com.maida.bankapi.repository.ContaRepository;
import br.com.maida.bankapi.repository.UsuarioRepository;
import br.com.maida.bankapi.service.exception.ContaNaoEncontradaException;
import br.com.maida.bankapi.service.exception.ObjetoJaExisteException;

@Service
public class ContaService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ContaRepository contaRepository;

	public Conta save(@Valid ContaForm form, Long idUsuario) {
		verificaConta(form);
		Conta conta = form.converter(usuarioRepository.findById(idUsuario).get());
		contaRepository.save(conta);
		return conta;

	}
	

	private void verificaConta(ContaForm form) {
		Optional<Conta> conta = contaRepository.findByNumber(form.getNumber());
		if (conta.isPresent()) {
			throw new ObjetoJaExisteException("Number");
		}
	}
	
	public Conta buscaConta(String contaNumero) {
		Optional<Conta> conta = contaRepository.findByNumber(contaNumero);
		
		return conta.get();
	}
	
	public void editar(Conta conta) {
		contaRepository.save(conta);
	}


	public Conta saldo(String account_number) {
		Optional<Conta> conta = contaRepository.findByNumber(account_number);
		if (conta.isEmpty()) {
			throw new ContaNaoEncontradaException("account_number");
		}
		return conta.get();
	}
}
