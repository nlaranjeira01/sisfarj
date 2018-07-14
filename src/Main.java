import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import data_source.AssociacaoMapper;
import data_source.AtletaMapper;
import data_source.AutenticacaoMapper;
import db.DB;
import domain.AssociacaoMT;
import domain.AtletaMT;
import domain.exceptions.MatriculaAssociacaoNaoEncontradaException;
import utils.StringAleatoria;

public class Main {

	public static void main(String[] args) throws MatriculaAssociacaoNaoEncontradaException
	{
		AssociacaoMapper assocM = new AssociacaoMapper();
		AtletaMapper atletaM = new AtletaMapper();
		ResultSet assocTabela = assocM.getTabela();
		ResultSet atletaTabela = atletaM.getTabela();
		
		/*
		assocM.insert(1, 543, new Date(), "Ryan's Association", "RA", "Mansão dos Aprovados", "987987560", 1);
		assocM.insert(2, 324, new Date(), "Paulo's Association", "PA", "Favela dos Reprovados, 0", "932248526", 2);
		assocM.insert(3, 212, new Date(), "Michael's Association", "MiA", "Favela dos Reprovados, 0, fundos", "983218123", 3);
		assocM.insert(4, 765, new Date(), "Nelson's Association", "NA", "Favela dos Reprovados, 0, banheiro", "N/A", 4);
		assocM.insert(5, 241, new Date(), "Matheus' Association", "MaA", "Vale do Silício, todos os números", "911832182, 1-800-501-7745", 5);
		*/
		/*
		atletaM.insert(11, new Date(), "Ryan", new Date(), new Date(), 1, 3234);
		atletaM.insert(14, new Date(), "Paulo", new Date(), new Date(), 2, 4235);
		atletaM.insert(12, new Date(), "Michael", new Date(), new Date(), 3, 5236);
		atletaM.insert(167, new Date(), "Nelson", new Date(), new Date(), 4, 6237);
		atletaM.insert(104, new Date(), "Matheus", new Date(), new Date(), 5, 7238);
		*/
		
		try
		{
			//assocM.update(2, AssociacaoMT.getNumeroOficio(assocTabela, 1), AssociacaoMT.getDataOficio(assocTabela, 1), AssociacaoMT.getNome(assocTabela, 1), AssociacaoMT.getSigla(assocTabela, 1), AssociacaoMT.getEndereco(assocTabela, 1), AssociacaoMT.getTelefone(assocTabela, 1), AssociacaoMT.getNComprovante(assocTabela, 1));
			//atletaM.update(2, AtletaMT.getNumeroOficio(atletaTabela, 1), AtletaMT.getDataOficio(atletaTabela, 1), AtletaMT.getNome(atletaTabela, 1),  AtletaMT.getDataNasc(atletaTabela, 1),  AtletaMT.getEntradaAssoc(atletaTabela, 1),  AtletaMT.getMatrAssoc(atletaTabela, 1),  AtletaMT.getNComprovante(atletaTabela, 1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		assocM.imprimirTabela(); //Imprime a tabela de Associação
		System.out.println("");
		atletaM.imprimirTabela(); 
		
		ResultSet assocRS = assocM.getTabela();	//todos os métodos dos Módulos de Tabela trabalharão com resultsets vindos de fora (não sei se é o certo)
		List<String[]> listaAssoc = AssociacaoMT.getListaMatrNome(assocRS); //retorna lista de matriculas e nomes de associações por ordem de nome
		
		System.out.println("");
		
		for(String[] matrNome : listaAssoc)
		{
			System.out.println(matrNome[0] + " " + matrNome[1]);
		}
		
		try
		{
			assocRS.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}	
		
		ResultSet atletaRS = atletaM.getTabela();	//todos os métodos dos Módulos de Tabela trabalharão com resultsets vindos de fora (não sei se é o certo)
		List<String[]> listaAtleta = AtletaMT.getListaMatrNome(atletaRS); //retorna lista de matriculas e nomes de associações por ordem de nome
		
		System.out.println("");
		
		for(String[] matrNome : listaAtleta)
		{
			System.out.println(matrNome[0] + " " + matrNome[1]);
		}
		
		try
		{
			atletaRS.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		AutenticacaoMapper autM = new AutenticacaoMapper();
		autM.imprimirTabela();
		DB.getInstancia().desligar();
	}
}
