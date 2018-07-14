package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_source.AtletaMapper;
import db.DB;
import domain.AtletaMT;

@SuppressWarnings("serial")
@WebServlet("/alterarAtleta")
public class ListarAtleta extends HttpServlet{

    private List<String> lista;

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        AtletaMapper amp = new AtletaMapper();

        try {
            ResultSet rs = amp.getTabela();
            lista = geraLista(AtletaMT.getListaMatrNome(amp.getTabela()));
            
      
            rs.close();
            for(String string : lista) {
            	System.out.println(string);		
            }
            

            request.setAttribute("lista", lista);
            request.getRequestDispatcher("selecionarAtleta.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DB.getInstancia().desligar();

    }

    private List<String> geraLista(List<String[]> lista){
        List<String> novaLista = new ArrayList<String>();

        for(String[] matrNome : lista){
           novaLista.add(matrNome[0] + " " + matrNome[1]);
        }

        return novaLista;
    }
}
