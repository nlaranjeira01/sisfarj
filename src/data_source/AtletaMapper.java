package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import domain.exceptions.MatriculaAssociacaoNaoEncontradaException;
import domain.exceptions.MatriculaNaoEncontradaException;

public class AtletaMapper extends MDAbstrato
{
	@Override
	protected String sqlSelecionarTabela()
	{
		return "SELECT * FROM atleta";
	}
	
	private final String sqlInsert = "INSERT INTO atleta (numeroOficio, dataOficio, nome, dataNasc, entradaAssoc, matr_assoc, nComprovante) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	
	// número, data do oficio, nome, data de nascimento do atleta, data de entrada na
	//associação e matricula da associação e número do comprovante de pagamento
	public int insert(int numeroOficio, java.util.Date dataOficio, String nome, java.util.Date dataNasc, java.util.Date entradaAssoc, int matr_assoc, int nComprovante) throws MatriculaAssociacaoNaoEncontradaException
	{
		PreparedStatement insertStatement = null;
		ResultSet rs = null;
		int indiceInsert = 0;
		
		try
		{ 
			insertStatement = DB.getInstancia().preparar(sqlInsert, new String[] {"MATRICULA"} );
			insertStatement.setInt(1, numeroOficio);
			insertStatement.setDate(2, new java.sql.Date(dataOficio.getTime()));
			insertStatement.setString(3, nome);
			insertStatement.setDate(4, new java.sql.Date(dataNasc.getTime()));
			insertStatement.setDate(5, new java.sql.Date(entradaAssoc.getTime()));
			insertStatement.setInt(6, matr_assoc);
			insertStatement.setInt(7, nComprovante);
			insertStatement.execute();
			rs = insertStatement.getGeneratedKeys();
			rs.next();
			indiceInsert = rs.getInt(1);
		}
		catch(org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException e)
		{
			throw new MatriculaAssociacaoNaoEncontradaException("Matricula da Associação não encontrada");
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return indiceInsert; //deve ser inalcançável		
	}

	public void update(Integer matricula, Integer numeroOficio, java.util.Date dataOficio, String nome, java.util.Date dataNasc, java.util.Date entradaAssoc, Integer matr_assoc, Integer nComprovante) throws MatriculaNaoEncontradaException, MatriculaAssociacaoNaoEncontradaException
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
			
			if(numeroOficio != null)
			{
				rs.updateInt("NUMEROOFICIO", numeroOficio);
			}
			if(dataOficio != null)
			{
				rs.updateDate("DATAOFICIO", new java.sql.Date(dataOficio.getTime()));
			}
			if(nome != null)
			{
				rs.updateString("NOME", nome);
			}
			if(dataNasc != null)
			{
				rs.updateDate("DATANASC", new java.sql.Date(dataNasc.getTime()));
			}
			if(entradaAssoc != null)
			{
				rs.updateDate("ENTRADAASSOC", new java.sql.Date(entradaAssoc.getTime()));
			}
			
			if(matr_assoc != null)
			{
				rs.updateInt("MATR_ASSOC", matr_assoc);
			}				
			
			if(nComprovante != null)
			{
				rs.updateInt("NCOMPROVANTE", nComprovante);
			}
			
			rs.updateRow();
		}
		catch(org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException e1)
		{
			throw new MatriculaAssociacaoNaoEncontradaException("Matrícula da Associação não encontrada");
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
