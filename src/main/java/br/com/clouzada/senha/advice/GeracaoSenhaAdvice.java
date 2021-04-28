package br.com.clouzada.senha.advice;

import br.com.clouzada.senha.exception.GeracaoSenhaException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GeracaoSenhaAdvice {
    @ResponseBody
    @ExceptionHandler(GeracaoSenhaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String geracaoSenhaHandler(GeracaoSenhaException e) {
        return e.getMessage();
    }
}