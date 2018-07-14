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
import data_source.AutenticacaoMapper;
import domain.AutenticacaoMT;
import jdk.nashorn.internal.runtime.ParserException;
import utils.StringAleatoria;

@SuppressWarnings("serial")
@WebServlet("/criarAssociacao")
public class CriaAssociacao extends HttpServlet{

    
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParserException
    {
    	if(		request.getParameter("nOficio") == null || request.getParameter("data") == null || request.getParameter("nome") == null ||
    			request.getParameter("sigla") == null||request.getParameter("endereco") == null || request.getParameter("telefone") == null ||
    			request.getParameter("nComprovante") == null) {
    		System.out.println("argumento invalido");
    	}
    	else
    	{
    		int nComprovante = Integer.parseInt(request.getParameter("nComprovante"));
    		int nOficio = Integer.parseInt(request.getParameter("nOficio"));
    		
    		try
    		{
    			SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
    			Date date = (Date)formato.parse(request.getParameter("data"));
    			AssociacaoMapper am = new AssociacaoMapper();
    			AutenticacaoMapper autM = new AutenticacaoMapper();
    			String senhaAcesso = new StringAleatoria(4).novaString();
    			
    			int matricula = autM.insert(senhaAcesso, AutenticacaoMT.TipoUsuario.TECNICO.valor());
    			
    			am.insert(	matricula, nOficio, date, request.getParameter("nome"), request.getParameter("sigla"),
    						request.getParameter("endereco"), request.getParameter("telefone"), nComprovante);
    			
    			System.out.println(matricula + " " + senhaAcesso);
    			db.DB.getInstancia().desligar();
    			request.setAttribute("login", matricula);
    			request.setAttribute("senha", senhaAcesso);
    			request.setAttribute("tipoUsuario", AutenticacaoMT.TipoUsuario.TECNICO.valor());
    			request.getRequestDispatcher("exibirCredenciais.jsp").forward(request, response);
    		}
    		catch(java.text.ParseException e)
    		{
    			System.out.println("Data invalida");
			}
    	}
    }

    
}