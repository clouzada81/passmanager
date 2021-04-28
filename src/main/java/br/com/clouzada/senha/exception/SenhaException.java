package br.com.clouzada.senha.exception;

public class SenhaException extends Exception {
	private static final long serialVersionUID = 2762893262805783365L;

	public SenhaException() {
		super();
	}

	public SenhaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SenhaException(String message, Throwable cause) {
		super(message, cause);
	}

	public SenhaException(String message) {
		super(message);
	}

	public SenhaException(Throwable cause) {
		super(cause);
	}
}