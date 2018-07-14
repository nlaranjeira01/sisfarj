package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.exceptions.CredenciaisNaoEncontradasException;

public class AutenticacaoMT
{
	private static final int USUARIO = 1;
	private static final int SENHA = 2;
	private static final int TIPOUSUARIO = 3;

	private AutenticacaoMT() {}
	
	public enum TipoUsuario
	{
	    TECNICO("Técnico"), SECRETARIO("Secretario"), DIRETOR("Diretor"), PESSOA("Pessoa");

		private final String tipo;

	    private TipoUsuario(String tipo)
	    {
	        this.tipo = tipo;
	    }

	    public String valor()
	    {
	        return tipo;
	    }
	}
	
	public static String verificarCredenciais(ResultSet tabela, int usuario, String senha) throws CredenciaisNaoEncontradasException
	{
		String tipoUsuario = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(usuario == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new CredenciaisNaoEncontradasException("Usuário/senha não encontrados");
				}

				tipoUsuario = tabela.getString(TIPOUSUARIO);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return tipoUsuario;
	}
}
