package domain.exceptions;

public class CredenciaisNaoEncontradasException extends Exception
{
	private static final long serialVersionUID = -2864336603695174525L;
	
	public CredenciaisNaoEncontradasException(String mensagem)
	{
		super(mensagem);
	}	
}
