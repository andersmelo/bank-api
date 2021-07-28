package br.com.maida.bankapi.service.exception;

public class ObjetoJaExisteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoJaExisteException(String msg) {
		super(msg);
	}
}
