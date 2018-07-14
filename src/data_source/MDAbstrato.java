package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import db.DB;

public abstract class MDAbstrato
{
	//private boolean tabelaCriada = false;
	//abstract protected String sqlCriarTabela();
	abstract protected String sqlSelecionarTabela();
	
	public void imprimirTabela()
	{
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ResultSetMetaData resultSetMetaData = null;
		
		try
		{
			statement = DB.getInstancia().preparar(sqlSelecionarTabela());
			resultSet = statement.executeQuery();
			resultSetMetaData = resultSet.getMetaData();
		}
		catch(SQLException e3) 
		{
			e3.printStackTrace();
		}
		
		int columnCount = 0;
		try
		{
			if(resultSetMetaData != null)
			{
				columnCount = resultSetMetaData.getColumnCount();				
			}
		}
		catch(SQLException e2)
		{
			e2.printStackTrace();
		}
		
		for(int i = 1; i <= columnCount; i++)
		{
			try
			{
				System.out.format("%38s", resultSetMetaData.getColumnName(i) + " | ");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		try
		{
			if(resultSet != null)
			{
				while(resultSet.next())
				{
					System.out.println("");
					
					for(int i = 1; i <= columnCount; i++)
					{
						try
						{
							System.out.format("%38s", resultSet.getString(i) + " | ");
						}
						catch(SQLException e)
						{
							e.printStackTrace();
						}
					}
				}
				System.out.println("");
			}
		}
		
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		if(statement != null)
		{
			try
			{
				statement.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public ResultSet getTabela()
	{
		ResultSet tabela = null;
		try
		{
			PreparedStatement stmtSelecionarTabela = DB.getInstancia().preparar(sqlSelecionarTabela());
			tabela = stmtSelecionarTabela.executeQuery();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return tabela;
	}
}
