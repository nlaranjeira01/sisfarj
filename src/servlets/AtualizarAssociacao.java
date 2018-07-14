package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AssociacaoMapper;
import domain.AssociacaoMT;
import domain.exceptions.MatriculaNaoEncontradaException;

@SuppressWarnings("serial")
@WebServlet("/atualizarAssociacao")

public class AtualizarAssociacao extends HttpServlet {
	
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("associacao"));
		
		String[] splitted= request.getParameter("associacao").split(" ");

		int matricula= Integer.parseInt(splitted[0]);

		String nome = splitted[1];
		
		AssociacaoMapper amp = new AssociacaoMapper();
		ResultSet tabela = amp.getTabela();
		
		String sigla = null;
		Date data = null;
		int nOficio = 0;
		String endereco = null;
		String telefone = null;
		int nComprovante = 0;
		
		try
		{
			sigla =  AssociacaoMT.getSigla(tabela, matricula);
			data = AssociacaoMT.getDataOficio(tabela, matricula);
			nOficio = AssociacaoMT.getNumeroOficio(tabela, matricula);
			endereco = AssociacaoMT.getEndereco(tabela, matricula);
			telefone = AssociacaoMT.getTelefone(tabela, matricula);
			nComprovante = AssociacaoMT.getNComprovante(tabela, matricula);	
		}
		catch(MatriculaNaoEncontradaException e)
		{
			request.getRequestDispatcher("matriculaNaoEncontrada.jsp").forward(request, response);	
		}
		
		request.setAttribute("nome", nome);
		request.setAttribute("sigla", sigla);
		request.setAttribute("data", data);
		request.setAttribute("nOficio", nOficio);
		request.setAttribute("matricula", matricula);
		request.setAttribute("endereco", endereco);
		request.setAttribute("telefone", telefone);
		request.setAttribute("nComprovante", nComprovante);
		
		request.getRequestDispatcher("alterarAssociacao.jsp").forward(request, response);	
	}
}
