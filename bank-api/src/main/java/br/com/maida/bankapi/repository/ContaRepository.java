package br.com.maida.bankapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maida.bankapi.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{

	Optional<Conta> findByNumber(String number);


}
