package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domain.exceptions.MatriculaNaoEncontradaException;

public class AssociacaoMT
{
	private static final int MATRICULA = 1;
	private static final int NUMEROOFICIO = 2;
	private static final int DATAOFICIO = 3;
	private static final int NOME = 4;
	private static final int SIGLA = 5;
	private static final int ENDERECO = 6;
	private static final int TELEFONE = 7;
	private static final int NCOMPROVANTE = 8;
	
	private AssociacaoMT() {}
	
	public static List<String[]> getListaMatrNome(ResultSet tabela)
	{
		List<String[]> matr_nomes = new ArrayList<String[]>();
		
		if(tabela != null)
		{
			String matricula, nome;
			int i = 0;

			try
			{
				tabela.beforeFirst();

				while(tabela.next())
				{
					matr_nomes.add(new String[2]);
					
					matricula = Integer.toString(tabela.getInt(MATRICULA));
					nome = tabela.getString(NOME);
					
					matr_nomes.get(i)[0] = matricula;
					matr_nomes.get(i++)[1] = nome;
				}
				
				//UHUUUU NOVA IGUAÇUUUU
				Collections.sort(matr_nomes, 	new Comparator<String[]>()
												{
													@Override
													public int compare(String[] s1, String[] s2)
													{
														return s1[1].toLowerCase().compareTo(s2[1].toLowerCase());
													}
												});
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return matr_nomes;
	}

	public static Integer getNComprovante(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		Integer nComprovante = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				nComprovante = tabela.getInt(NCOMPROVANTE);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return nComprovante;
	}

	public static Integer getNumeroOficio(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		Integer numeroOficio = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					System.out.println(tabela.isAfterLast() + " " + tabelaVazia);
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				numeroOficio = tabela.getInt(NUMEROOFICIO);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return numeroOficio;
	}

	public static String getTelefone(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		String telefone = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				telefone = tabela.getString(TELEFONE);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return telefone;
	}

	public static String getEndereco(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		String endereco = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				endereco = tabela.getString(ENDERECO);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return endereco;
	}

	public static String getSigla(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		String sigla = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				sigla = tabela.getString(SIGLA);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return sigla;
	}

	public static String getNome(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		String nome = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				nome = tabela.getString(NOME);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return nome;
	}

	public static java.util.Date getDataOficio(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		java.util.Date dataOficio = null;
		
		if(tabela != null)
		{
			try
			{
				boolean tabelaVazia = true;
				
				tabela.beforeFirst();

				while(tabela.next())
				{
					tabelaVazia = false;
					
					if(matricula == tabela.getInt(1))
					{
						break;
					}
				}
				
				if(tabela.isAfterLast() || tabelaVazia)
				{
					throw new MatriculaNaoEncontradaException("Matrícula não encontrada");
				}

				dataOficio = new java.util.Date(tabela.getDate(DATAOFICIO).getTime());
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return dataOficio;
	}
}
