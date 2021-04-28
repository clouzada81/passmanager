package br.com.clouzada.senha.advice;

import br.com.clouzada.senha.exception.SenhaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class SenhaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(SenhaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String grupoNotFoundHandler(SenhaNotFoundException ex) {
        return ex.getMessage();
    }
}