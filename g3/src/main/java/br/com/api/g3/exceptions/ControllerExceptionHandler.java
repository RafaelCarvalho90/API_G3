package br.com.api.g3.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

//@SecurityScheme(
//        name = "Bearer Auth",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        scheme = "bearer"
//    )
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
    @Override
//	@SecurityRequirement(name="Bearer Auth")
//	@PreAuthorize("hasRole('ADMIN')")
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		ErroResposta erroResposta = new ErroResposta();
		erroResposta.setDataHora(LocalDateTime.now());
		erroResposta.setErros(new ArrayList<>());
		
		for(FieldError fieldError : ex.getFieldErrors()) {
			erroResposta.getErros().add(new MensagemErro(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
		
		
		
	}
}
