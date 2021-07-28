package br.com.maida.bankapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maida.bankapi.controller.form.ContaForm;
import br.com.maida.bankapi.modelo.Transferencia;
import br.com.maida.bankapi.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	public Transferencia inserir(@Valid ContaForm form, Long idUsuario) {
		
		Transferencia transferencia = form.converter(transferenciaRepository.findById(idUsuario).get());
		transferenciaRepository.save(transferencia);
		return transferencia;

	}
}
