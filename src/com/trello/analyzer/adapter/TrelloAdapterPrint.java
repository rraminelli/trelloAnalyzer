package com.trello.analyzer.adapter;

import com.trello.analyzer.bean.Card;
import com.trello.analyzer.bean.List;
import com.trello.analyzer.bean.TrelloAnalyzer;

public class TrelloAdapterPrint extends AbstractTrelloAdapter {

	@Override
	protected String toAnalyserAdapter(TrelloAnalyzer trelloAnalyzer) {
		
		System.out.println("---------- Analise Trello -------------------------");
		System.out.println("Nome do projeto: "+trelloAnalyzer.getTrello().getName());
		System.out.println("Qtde. Total de Cards = "+trelloAnalyzer.getTrello().getCards().size());
		
		System.out.println("---------- Origem das tarefas -----------------------");
		System.out.println("Qtde. de (blue) 	"+trelloAnalyzer.getTrello().getLabelNames().getBlue()+" = "+trelloAnalyzer.getColors().get("blue").size());
		System.out.println("Qtde. de (green)	"+trelloAnalyzer.getTrello().getLabelNames().getGreen()+" = "+trelloAnalyzer.getColors().get("green").size());
		System.out.println("Qtde. de (orange) 	"+trelloAnalyzer.getTrello().getLabelNames().getOrange()+" = "+trelloAnalyzer.getColors().get("orange").size());
		System.out.println("Qtde. de (purple) 	"+trelloAnalyzer.getTrello().getLabelNames().getPurple()+" = "+trelloAnalyzer.getColors().get("purple").size());
		System.out.println("Qtde. de (red) 		"+trelloAnalyzer.getTrello().getLabelNames().getRed()+" = "+trelloAnalyzer.getColors().get("red").size());
		System.out.println("Qtde. de (yellow) 	"+trelloAnalyzer.getTrello() .getLabelNames().getYellow()+" = "+trelloAnalyzer.getColors().get("yellow").size());
		
		System.out.println("---------- Testes ---------------------------------");
		int qtdeTestesTotal = 0;
		int qtdeTestesFalha = 0;
		for (String t : trelloAnalyzer.getTests().keySet()) {
			System.out.println("Qtde. de Testes " + t + " = " + trelloAnalyzer.getTests().get(t).size());			
			if(!t.equals(TrelloAnalyzer.TIPO_TESTE)) //Retira os que estao para testar
				qtdeTestesTotal += trelloAnalyzer.getTests().get(t).size();			
			if(t.contains("Teste:Falha:"))//Apenas os que estao com falha
				qtdeTestesFalha += trelloAnalyzer.getTests().get(t).size();
		}		
		System.out.println("Qtde. de Testes Realizados = " + qtdeTestesTotal);
		if(qtdeTestesTotal > 0)
			System.out.println("Qtde. de Testes Falha = " + qtdeTestesFalha + " (" + ((qtdeTestesFalha/qtdeTestesTotal)*100)+"%)"); //Indice em cima dos realizados
		
		System.out.println("---------- Andamento das tarefas -------------------");
		for (List l : trelloAnalyzer.getTrello().getLists()) {
			System.out.println("Qtde de tarefas "+l.getName()+" = "+trelloAnalyzer.getLists().get(l.getId()).size());			
		}
		
		System.out.println("---------- Status das tarefas -------------------");
		for (Card c : trelloAnalyzer.getTrello().getCards()) {
			
			System.out.println(c.getName() + " == Início: " + c.getInicio() + " == Termino: " + c.getTermino() +" == Tempo: " + c.getDuracao() + " == Status "+c.getStatus()+"%");
			
		}
		
		return "OK";
	}

	
	
}
