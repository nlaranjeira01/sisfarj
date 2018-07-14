package domain.exceptions;

public class MatriculaAssociacaoNaoEncontradaException extends Exception
{
	private static final long serialVersionUID = -1143578508678705380L;
	
	public MatriculaAssociacaoNaoEncontradaException(String mensagem)
	{
		super(mensagem);
	}

}
