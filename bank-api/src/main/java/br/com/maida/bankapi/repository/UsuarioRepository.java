package br.com.maida.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maida.bankapi.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
