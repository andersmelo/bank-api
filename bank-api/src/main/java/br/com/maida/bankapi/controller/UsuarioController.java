package br.com.maida.bankapi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.maida.bankapi.controller.form.UsuarioForm;
import br.com.maida.bankapi.dto.UsuarioDto;
import br.com.maida.bankapi.modelo.Usuario;
import br.com.maida.bankapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		usuarioRepository.save(usuario);
		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}

}
