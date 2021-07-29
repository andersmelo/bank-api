package br.com.maida.bankapi.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.maida.bankapi.service.exception.ContaNaoEncontradaException;
import br.com.maida.bankapi.service.exception.EmailJaExisteException;
import br.com.maida.bankapi.service.exception.ObjetoJaExisteException;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErroDeFormularioDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ObjetoJaExisteException.class)
	public ErroDeFormularioDto handle(ObjetoJaExisteException exception) {
		return new ErroDeFormularioDto(exception.getMessage(), "Já existe uma Conta com o numero informado!");
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ContaNaoEncontradaException.class)
	public ErroDeFormularioDto handle(ContaNaoEncontradaException exception) {
		return new ErroDeFormularioDto(exception.getMessage(), "Conta não encontrada!");
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmailJaExisteException.class)
	public ErroDeFormularioDto handle(EmailJaExisteException exception) {
		return new ErroDeFormularioDto(exception.getMessage(), "Já existe um usuário com o email informado!");
	}
}
