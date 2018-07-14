package data_source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;

public class AutenticacaoMapper extends MDAbstrato {

	@Override
	protected String sqlSelecionarTabela()
	{
		return "SELECT * FROM AUTENTICACAO";
	}
	
	private final String sqlInsert = "INSERT INTO autenticacao (senha, tipoUsuario) VALUES (?, ?)";

	public int insert(String senha, String tipoUsuario)
	{
		PreparedStatement insertStatement = null;
		ResultSet rs = null;
		int indiceInsert = 0;
		
		try
		{ 
			insertStatement = DB.getInstancia().preparar(sqlInsert, new String[] {"USUARIO"} );
			insertStatement.setString(1, senha);
			insertStatement.setString(2, tipoUsuario);
			insertStatement.execute();
			rs = insertStatement.getGeneratedKeys();
			rs.next();
			indiceInsert = rs.getInt(1);
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
		return indiceInsert;	
	}
}
