package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AutenticacaoMapper;
import db.DB;
import domain.AutenticacaoMT;
import domain.AutenticacaoMT.TipoUsuario;
import domain.exceptions.CredenciaisNaoEncontradasException;

@WebServlet("/IdentificarUsuario")
public class IdentificarUsuario extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String FILIAR_ASSOCIACAO = "ECU1";
	private static final String ALTERAR_ASSOCIACAO = "ECU2";
	private static final String LISTAR_ASSOCIACAO = "ECU3";
	private static final String CADASTRAR_ATLETA = "ECU4";
	private static final String ALTERAR_ATLETA = "ECU5";
	private static final String TRANSFERIR_ATLETA = "ECU6";
	private static final String INSERIR_RESULTADO_ATLETA = "ECU7";
	private static final String INSERIR_ATLETA_COMPETICAO = "ECU8";
	private static final String INCLUIR_LOCAIS_COMPETICAO = "ECU10";
	private static final String ALTERAR_LOCAIS_COMPETICAO = "ECU11";
	private static final String LISTAR_LOCAIS_COMPETICAO = "ECU12";
	private static final String CRIAR_COMPETICAO = "ECU13";
	private static final String ALTERAR_COMPETICAO = "ECU14";
	private static final String LISTAR_COMPETICAO = "ECU16";
	private static final String LISTAR_BALIZ_COMPETICAO = "ECU17";
	private static final String LISTAR_PONTUACAO_COMPETICAO = "ECU18";
	private static final String LISTAR_PONTUACAO_FINAL = "ECU19";

    public IdentificarUsuario()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String login = request.getParameter("loginUsuario");
		String senha = request.getParameter("senhaUsuario");
		String opcaoMenu = request.getParameter("opcao");
		
		if(!login.matches("[0-9]+"))
		{
			request.getRequestDispatcher("credenciaisNaoEncontradas.jsp").forward(request, response);
			return;
		}
		
		int intLogin = Integer.parseInt(login);
		AutenticacaoMapper autM = new AutenticacaoMapper();
		ResultSet tabelaAut = autM.getTabela();
		String tipoUsuario = null;
		
		try
		{
			tipoUsuario = AutenticacaoMT.verificarCredenciais(tabelaAut, intLogin, senha);
		}
		catch(CredenciaisNaoEncontradasException e )
		{
			request.getRequestDispatcher("credenciaisNaoEncontradas.jsp").forward(request, response);
			return;
		}
		
		switch(opcaoMenu)
		{
			case FILIAR_ASSOCIACAO:
				if(tipoUsuario.equals(TipoUsuario.SECRETARIO.valor()) || tipoUsuario.equals(TipoUsuario.DIRETOR.valor()))
				{
					request.getRequestDispatcher("criarAssociacao.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("acessoNegado.jsp").forward(request, response);
				}
				break;
			case ALTERAR_ASSOCIACAO:
				if(tipoUsuario.equals(TipoUsuario.SECRETARIO.valor()) || tipoUsuario.equals(TipoUsuario.DIRETOR.valor()))
				{
					request.getRequestDispatcher("/alterarAssociacao").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("acessoNegado.jsp").forward(request, response);
				}
				break;
			case LISTAR_ASSOCIACAO:
				if(tipoUsuario.equals(TipoUsuario.SECRETARIO.valor()) || tipoUsuario.equals(TipoUsuario.DIRETOR.valor()))
				{
					request.getRequestDispatcher("/listarAssociacao").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("acessoNegado.jsp").forward(request, response);
				}
				
				break;
			case CADASTRAR_ATLETA:
				if(tipoUsuario.equals(TipoUsuario.SECRETARIO.valor()) || tipoUsuario.equals(TipoUsuario.DIRETOR.valor()))
				{
					request.getRequestDispatcher("cadastrarAtleta.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("acessoNegado.jsp").forward(request, response);
				}
				
				break;
			case ALTERAR_ATLETA:
				if(tipoUsuario.equals(TipoUsuario.SECRETARIO.valor()) || tipoUsuario.equals(TipoUsuario.DIRETOR.valor()))
				{
					request.getRequestDispatcher("/alterarAtleta").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("acessoNegado.jsp").forward(request, response);
				}
				break;
			case TRANSFERIR_ATLETA:
				break;
			case INSERIR_RESULTADO_ATLETA:
				break;
			case INSERIR_ATLETA_COMPETICAO:
				break;
			case INCLUIR_LOCAIS_COMPETICAO:
				break;
			case ALTERAR_LOCAIS_COMPETICAO:
				break;
			case LISTAR_LOCAIS_COMPETICAO:
				break;
			case CRIAR_COMPETICAO:
				break;
			case ALTERAR_COMPETICAO:
				break;
			case LISTAR_COMPETICAO:
				break;
			case LISTAR_BALIZ_COMPETICAO:
				break;
			case LISTAR_PONTUACAO_COMPETICAO:
				break;
			case LISTAR_PONTUACAO_FINAL:
				break;
			default:
				response.getWriter().append("VALUE DE CASO DE USO NÃO RECONHECIDO");
				break;
		}

		try
		{
			tabelaAut.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		DB.getInstancia().desligar();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
