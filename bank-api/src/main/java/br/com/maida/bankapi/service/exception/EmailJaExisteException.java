package br.com.maida.bankapi.service.exception;

public class EmailJaExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailJaExisteException(String msg) {
		super(msg);
	}
}
