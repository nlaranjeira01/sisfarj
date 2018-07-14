package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AtletaMapper;
import db.DB;
import domain.exceptions.MatriculaAssociacaoNaoEncontradaException;
import domain.exceptions.MatriculaNaoEncontradaException;
import jdk.nashorn.internal.runtime.ParserException;


@SuppressWarnings("serial")
@WebServlet("/updateAtleta")
public class UpdateAtleta extends HttpServlet {
	
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParserException{
		
		int nOficio = Integer.parseInt(request.getParameter("nOficio"));
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		
		try
		{
			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
			Date dateEntradaAssoc = (Date)formato.parse(request.getParameter("dataEntradaAssoc"));
			Date dateOficio = (Date)formato.parse(request.getParameter("dataOficio"));
			AtletaMapper am = new AtletaMapper();

			am.update(matricula, nOficio, dateOficio, request.getParameter("nome"), null, dateEntradaAssoc, null, null);
			
			DB.getInstancia().desligar();
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			
		}
		catch(java.text.ParseException e)
		{
			System.out.println("Data invalida");
		}
		catch(MatriculaNaoEncontradaException e)
		{
			request.getRequestDispatcher("matriculaNaoEncontrada.jsp").forward(request, response);	
		}
		catch(MatriculaAssociacaoNaoEncontradaException e)
		{
			request.getRequestDispatcher("matriculaAssociacaoNaoEncontrada.jsp").forward(request, response);	
		}
	}

}
