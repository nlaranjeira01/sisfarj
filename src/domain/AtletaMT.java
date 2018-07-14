package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data_source.AtletaMapper;
import domain.exceptions.MatriculaNaoEncontradaException;

public class AtletaMT
{
	private static final int MATRICULA = 1;
	private static final int NUMEROOFICIO = 2;
	private static final int DATAOFICIO = 3;
	private static final int NOME = 4;
	private static final int DATANASC = 5;
	private static final int ENTRADAASSOC = 6;
	private static final int MATR_ASSOC = 7;
	private static final int NCOMPROVANTE = 8;
	
	private AtletaMT() {}
	
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
														return s1[1].compareTo(s2[1]);
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

	public static Integer getMatrAssoc(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		Integer matrAssoc = null;
		
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

				matrAssoc = tabela.getInt(MATR_ASSOC);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return matrAssoc;
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

	public static java.util.Date getEntradaAssoc(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		java.util.Date entradaAssoc = null;
		
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

				entradaAssoc = new java.util.Date(tabela.getDate(ENTRADAASSOC).getTime());
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return entradaAssoc;
	}

	public static java.util.Date getDataNasc(ResultSet tabela, int matricula) throws MatriculaNaoEncontradaException
	{
		java.util.Date dataNasc = null;
		
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

				dataNasc = new java.util.Date(tabela.getDate(DATANASC).getTime());
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return dataNasc;
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
