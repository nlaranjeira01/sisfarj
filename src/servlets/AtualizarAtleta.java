package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AtletaMapper;
import domain.AtletaMT;
import domain.exceptions.MatriculaNaoEncontradaException;

@SuppressWarnings("serial")
@WebServlet("/atualizarAtleta")
public class AtualizarAtleta extends HttpServlet{
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("atleta"));
		
		String[] splitted= request.getParameter("atleta").split(" ");

		int matricula= Integer.parseInt(splitted[0]);

		String nome = splitted[1];
		
		AtletaMapper amp = new AtletaMapper();
		ResultSet tabela = amp.getTabela();

		Date dataEntradaAssoc = null;
		int nOficio = 0;
		Date dataOficio = null;
		
			try
			{
				dataEntradaAssoc = AtletaMT.getEntradaAssoc(tabela, matricula);
				nOficio = AtletaMT.getNumeroOficio(tabela, matricula);
				dataOficio = AtletaMT.getDataOficio(tabela, matricula);
			}
			catch(MatriculaNaoEncontradaException e)
			{
				request.getRequestDispatcher("matriculaNaoEncontrada.jsp").forward(request, response);	
			}
			
		
		request.setAttribute("nome", nome);
		request.setAttribute("dataEntradaAssoc", dataEntradaAssoc);
		request.setAttribute("nOficio", nOficio);
		request.setAttribute("dataOficio", dataOficio);
		request.setAttribute("matricula", matricula);
		
		request.getRequestDispatcher("alterarAtleta.jsp").forward(request, response);
		

		
	}
}
