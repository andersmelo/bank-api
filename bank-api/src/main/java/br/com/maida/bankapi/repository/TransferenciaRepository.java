package br.com.maida.bankapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maida.bankapi.modelo.Transferencia;


public interface TransferenciaRepository extends JpaRepository<Transferencia, Long>{

}
