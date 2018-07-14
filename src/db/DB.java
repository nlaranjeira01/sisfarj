package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB
{
	private static DB instancia;
	private static final int NOME_TABELA = 0;
	private static final int COLUNAS_TABELA = 1;
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_CREATE_URL = "jdbc:derby:c:/sisfarjDB;create=true";
	private static final String JDBC_SHUTDOWN_URL = "jdbc:derby:c:/sisfarjDB;shutdown=true";	
	private static Connection conexao;
	private List<String[]> schema;
	// DB
    private DB() throws SQLException
    {
    	int i = 0;
    	schema = new ArrayList<String[]>();
    	
    	//====================== DDL AUTENTICACAO =======================
    	schema.add(new String[2]);
    	schema.get(i)[NOME_TABELA] = "autenticacao";
    	schema.get(i++)[COLUNAS_TABELA] =	"usuario INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
    										"senha VARCHAR(255) NOT NULL, " +
    										"tipoUsuario VARCHAR(255) NOT NULL, " +
											"CONSTRAINT autenticacao_pk PRIMARY KEY (usuario) ";

    	//====================== DDL ASSOCIACAO =======================
    	schema.add(new String[2]);
    	schema.get(i)[NOME_TABELA] = "associacao";
    	schema.get(i++)[COLUNAS_TABELA] =	"matricula INTEGER NOT NULL REFERENCES autenticacao(usuario), " +
    										"numeroOficio INTEGER NOT NULL, " +
    										"dataOficio DATE NOT NULL, " +
    										"nome VARCHAR(255) NOT NULL, " +
    										"sigla VARCHAR(255) NOT NULL, " +
    										"endereco VARCHAR(255) NOT NULL, " +
    										"telefone VARCHAR(255) NOT NULL, " +
    										"nComprovante INTEGER NOT NULL, " +
    										"CONSTRAINT assoc_pk PRIMARY KEY (matricula) ";

    	//====================== DDL ATLETA =======================
    	schema.add(new String[2]);
    	schema.get(i)[NOME_TABELA] = "atleta";
    	schema.get(i++)[COLUNAS_TABELA] =	"matricula INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
    										"numeroOficio INTEGER NOT NULL, " +
    										"dataOficio DATE NOT NULL, " +
    										"nome VARCHAR(255) NOT NULL, " +
    										"dataNasc DATE NOT NULL, " +
    										"entradaAssoc DATE NOT NULL, " +
											"matr_assoc INTEGER REFERENCES associacao(matricula), " +
    										"nComprovante INTEGER NOT NULL, " +
											"CONSTRAINT atleta_pk PRIMARY KEY (matricula) ";
    	
    	try
        {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(JDBC_CREATE_URL);
            conexao.setAutoCommit(true);
            criarSchema();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Criação do DB falhou: " + e.getMessage());
        }
    }
    
    public Connection getConexao()
    {
        return conexao;
    }
	
    public static DB getInstancia()
    {
    	assegurarConexao();
        return instancia;
    }
    
    public PreparedStatement preparar(String sql) throws SQLException
    {
    	//assegurarConexao();
    	return conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }
    
    public PreparedStatement preparar(String sql, String[] colunasAutoGen) throws SQLException
    {
    	//assegurarConexao();
    	return conexao.prepareStatement(sql, colunasAutoGen);
    }
    
    private void criarSchema()
    {
    	PreparedStatement stmt = null;

    	for(String[] ddl : schema)
    	{
    		//System.out.println(ddl[NOME_TABELA] + "\n" + ddl[COLUNAS_TABELA]);
			try
			{
				stmt = conexao.prepareStatement(
													"CREATE TABLE " + ddl[NOME_TABELA] + " " +
													"( " +
														ddl[COLUNAS_TABELA] + " " +
													")"
												);
				
				stmt.executeUpdate();
			}
			catch(SQLException e)
			{
				if(e.getSQLState().equals("X0Y32"))
				{
					//System.out.println(ddl[NOME_TABELA] + " Tabela já existe");
					//tabela já existe... segue a vida
					//cuidado, esse sqlstate pode significar que constraints já existem também
				}
				else
				{
					e.printStackTrace();				
				}
			}
			
			try
			{
				if(stmt != null)
					stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
    	}
    }
    
    private static void assegurarConexao()
    {
        try
        {
	        if(instancia == null)
	        {
				instancia = new DB();
	        }
	        else if(instancia.getConexao().isClosed())
	        {
	            instancia = new DB();
	        }
        }
        catch(SQLException e)
        {
			e.printStackTrace();
        }
    }
    
    public void fecharConexao() throws SQLException
    {
    	if(conexao != null)
    	{
        	conexao.close();    		
    	}
    }
    
    public void desligar()
    {
        try
        {
        	if(conexao != null)
        	{
            	conexao.close();        		
        	}
        	
			conexao = DriverManager.getConnection(JDBC_SHUTDOWN_URL);
	        conexao.close();
		}
        catch(SQLException e)
        {
        	if(e.getSQLState().equals("08006"))
        	{
        		return;
        	}
        	else
        	{
    			e.printStackTrace();        		
        	}
		}
    }
}
