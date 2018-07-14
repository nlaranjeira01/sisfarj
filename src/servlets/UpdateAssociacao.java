package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AssociacaoMapper;
import domain.exceptions.MatriculaNaoEncontradaException;
import jdk.nashorn.internal.runtime.ParserException;


@SuppressWarnings("serial")
@WebServlet("/updateAssociacao")
public class UpdateAssociacao extends HttpServlet {
	
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParserException{
		
		int nComprovante = Integer.parseInt(request.getParameter("nComprovante"));
		int nOficio = Integer.parseInt(request.getParameter("nOficio"));
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		
		try
		{
			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
			Date date = (Date)formato.parse(request.getParameter("data"));
			AssociacaoMapper am = new AssociacaoMapper();

			am.update(matricula, nOficio, date, request.getParameter("nome"), request.getParameter("sigla"), request.getParameter("endereco"),
					request.getParameter("telefone"), nComprovante);
			
			db.DB.getInstancia().desligar();
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
	}

}
