package br.com.clouzada.senha.exception;

public class SenhaNotFoundException extends RuntimeException {

    public SenhaNotFoundException(Long id) {
        super("O registro " + id + " não foi encontrado");
    }
}