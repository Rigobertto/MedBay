package projeto.exception;

public class AutException extends Exception{
	private static final long SERIAL_VERSION_UID = 1L;
	
	public AutException() {
		super("Login ou Senha inválido!");
	}
}
