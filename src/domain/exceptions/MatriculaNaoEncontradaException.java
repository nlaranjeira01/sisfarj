package domain.exceptions;

public class MatriculaNaoEncontradaException extends Exception
{
	private static final long serialVersionUID = -3657798545121089351L;

	public MatriculaNaoEncontradaException(String mensagem)
	{
		super(mensagem);
	}
}
