package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AtletaMapper;
import domain.AtletaMT;
import domain.exceptions.MatriculaAssociacaoNaoEncontradaException;

@SuppressWarnings("serial")
@WebServlet("/criaAtleta")
public class CriaAtleta extends HttpServlet{
	
	@Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String nome = request.getParameter("nome");
		int numeroOficio = Integer.parseInt(request.getParameter("nOficio"));
		int matr_assoc = Integer.parseInt(request.getParameter("matriculaAssociacao"));
		int nComprovante = Integer.parseInt(request.getParameter("nComprovante"));
		
		AtletaMapper am = new AtletaMapper();
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date dataNasc = (Date)formato.parse(request.getParameter("nascimento"));
			Date dataOficio = (Date)formato.parse(request.getParameter("dataOficio"));
			Date entradaAssoc = (Date)formato.parse(request.getParameter("dataEntrada"));
			
			am.insert(numeroOficio, dataOficio, nome, dataNasc, entradaAssoc, matr_assoc, nComprovante);
			
			List<String> lista;
			ResultSet rs = am.getTabela();
			
			lista = geraLista(AtletaMT.getListaMatrNome(am.getTabela()));
			
			for(String string: lista) {
				System.out.println(string);
			}
			
			db.DB.getInstancia().desligar();
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		catch (MatriculaAssociacaoNaoEncontradaException e)
		{
			request.getRequestDispatcher("matriculaAssociacaoNaoEncontrada.jsp").forward(request, response);
		}
		
	}
	
    private List<String> geraLista(List<String[]> lista){
        List<String> novaLista = new ArrayList<String>();

        for(String[] matrNome : lista){
           novaLista.add(matrNome[0] + " " + matrNome[1]);
        }

        return novaLista;
    }

	

}


