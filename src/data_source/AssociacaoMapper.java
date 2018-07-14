package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import domain.exceptions.MatriculaNaoEncontradaException;

public class AssociacaoMapper extends MDAbstrato
{
	@Override
	protected String sqlSelecionarTabela()
	{
		return "SELECT * FROM associacao";
	}
	
	private final String sqlInsert = 	"INSERT INTO associacao (matricula, numeroOficio, dataOficio, nome, sigla, endereco, telefone, nComprovante) " + 
									 	"VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	
	public void insert(int matricula, int numeroOficio, java.util.Date dataOficio, String nome, String sigla, String endereco, String telefone, int nComprovante)
	{
		PreparedStatement insertStatement = null;
		ResultSet rs = null;
		
		try
		{
			insertStatement = DB.getInstancia().preparar(sqlInsert);
			insertStatement.setInt(1, matricula);
			insertStatement.setInt(2, numeroOficio);
			insertStatement.setDate(3, new java.sql.Date(dataOficio.getTime()));
			insertStatement.setString(4, nome);
			insertStatement.setString(5, sigla);
			insertStatement.setString(6, endereco);
			insertStatement.setString(7, telefone);
			insertStatement.setInt(8, nComprovante);
			insertStatement.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();
				}
				
				if(insertStatement != null)
				{
					insertStatement.close();					
				}
				
			}
			catch(SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}
	
	public void update(Integer matricula, Integer numOficio, java.util.Date dataOficio, String nome, String sigla, String endereco, String telefone, Integer nComprovante) throws MatriculaNaoEncontradaException
	{
		PreparedStatement selectStatement = null;
		ResultSet rs = null;
		
		try
		{
			boolean tabelaVazia = true;
			
			selectStatement = DB.getInstancia().preparar(sqlSelecionarTabela());
			rs = selectStatement.executeQuery();
			rs.beforeFirst();
			
			while(rs.next())
			{
				tabelaVazia = false;
				
				if(matricula == rs.getInt(1))
				{
					break;
				}
			}
			
			if(rs.isAfterLast() || tabelaVazia)
			{
				throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
			}
				
			if(numOficio != null)
			{
				rs.updateInt("NUMEROOFICIO", numOficio);
			}
			if(dataOficio != null)
			{
				rs.updateDate("DATAOFICIO", new java.sql.Date(dataOficio.getTime()));
			}
			if(nome != null)
			{
				rs.updateString("NOME", nome);
			}
			if(sigla != null)
			{
				rs.updateString("SIGLA", sigla);
			}
			if(endereco != null)
			{
				rs.updateString("ENDERECO", endereco);
			}
			if(telefone != null)
			{
				rs.updateString("TELEFONE", telefone);
			}
			if(nComprovante != null)
			{
				rs.updateInt("NCOMPROVANTE", nComprovante);
			}
			
			rs.updateRow();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null)
				{
					rs.close();					
				}
				
				if(selectStatement != null)
				{
					selectStatement.close();					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
