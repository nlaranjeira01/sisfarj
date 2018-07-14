import java.sql.ResultSet;
import java.sql.SQLException;

import data_source.AutenticacaoMapper;
import db.DB;
import domain.AutenticacaoMT;
import utils.StringAleatoria;

public class AddCredenciais {
	public static void main(String[] args)
	{
		AutenticacaoMapper autM = new AutenticacaoMapper();
		ResultSet autRS = autM.getTabela();
		
		autM.insert(new StringAleatoria(4).novaString(), AutenticacaoMT.TipoUsuario.SECRETARIO.valor());

		try
		{
			autRS.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		DB.getInstancia().desligar();
	}
}
