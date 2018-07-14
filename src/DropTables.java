import java.sql.SQLException;

import db.DB;

public class DropTables
{
	
	public static void main(String[] args)
	{
		try
		{
			DB.getInstancia().preparar("DROP TABLE ATLETA").execute();		
			DB.getInstancia().preparar("DROP TABLE ASSOCIACAO").execute();
			DB.getInstancia().preparar("DROP TABLE AUTENTICACAO").execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DB.getInstancia().desligar();			
		}
	}
}
