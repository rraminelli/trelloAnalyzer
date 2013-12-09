package com.trello.analyzer.adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.trello.analyzer.bean.Card;
import com.trello.analyzer.bean.Label;
import com.trello.analyzer.bean.List;
import com.trello.analyzer.bean.Trello;
import com.trello.analyzer.bean.TrelloAnalyzer;

public class TrelloReader {

	private static TrelloReader instance;
	
	private TrelloReader(){
		
	}
	
	public static TrelloReader getInstance(){
		if(instance == null){
			instance = new TrelloReader();
		}
		return instance;
	}
	
	public TrelloAnalyzer formatObject(Trello trello){
		
		TrelloAnalyzer trelloAnalyzer = new TrelloAnalyzer();
		
		trelloAnalyzer.setTrello(trello);
		
		for (List l : trello.getLists()) {
			trelloAnalyzer.getLists().put(l.getId(), new ArrayList<Card>());
		}
				
		for (Card c : trello.getCards()) {
					
			if(c.getDesc()!=null && c.getDesc().contains("#Teste:"))
				trelloAnalyzer.getTests().get(c.getDesc().substring(c.getDesc().indexOf("#Teste:"), c.getDesc().lastIndexOf(":Teste#")+7)).add(c);
				
			c.setStatus(getStatus(c.getDesc()));
				
			c.setObservacao(getObservacao(c.getDesc()));
			
			setInicioFim(c);
					
			c.setDuracao(getDuracao(c.getDesc()));
					
			//Adiciona o card no seu tipo de tarefa
			trelloAnalyzer.getLists().get(c.getIdList()).add(c);
			//Adiciona o card na sua cor
			for (Label l : c.getLabels()) {
				trelloAnalyzer.getColors().get(l.getColor()).add(c);
			}
		}
		
		return trelloAnalyzer;
		
	}
	
	private int getStatus(String desc) {
		
		if(!desc.contains("#Status:"))
			return 0;
		
		String tmp = desc.substring(desc.indexOf("#Status:"), desc.lastIndexOf(":Status#")+8);
		
		return Integer.parseInt(tmp.replace("#Status:", "").replace("%:Status#", ""));
		
	}
	
	private int getDuracao(String desc) {
		
		if(!desc.contains("#Duracao:"))
			return 0;
		
		String tmp = desc.substring(desc.indexOf("#Duracao:"), desc.lastIndexOf(":Duracao#")+9);
		
		return Integer.parseInt(tmp.replace("#Duracao:", "").replace(":Duracao#", ""));
		
	}
	
	private String getObservacao(String desc) {
		
		if(!desc.contains("#Obs:"))
			return "";
		
		String tmp = desc.substring(desc.indexOf("#Obs:"), desc.lastIndexOf(":Obs#")+5);
		
		return tmp.replace("#Obs:", "").replace(":Obs#", "");
		
	}
	
	private void setInicioFim(Card card) {
		
		if(!card.getDesc().contains("#Inicio:"))
			return;
		
		java.text.DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
		
		String tmp = card.getDesc().substring(card.getDesc().indexOf("#Inicio:"), card.getDesc().lastIndexOf(":Inicio#")+8);
		
		tmp = tmp.replace("#Inicio:", "").replace(":Inicio#", "");
		
		try {
			if(!"".equals(tmp))
				card.setInicio(df.parse(tmp));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(!card.getDesc().contains("#Termino:"))
			return;
		
		tmp = card.getDesc().substring(card.getDesc().indexOf("#Termino:"), card.getDesc().lastIndexOf(":Termino#")+8);
		
		tmp = tmp.replace("#Termino:", "").replace(":Termino#", "");
		
		try {
			if(!"".equals(tmp))
				card.setTermino(df.parse(tmp));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(card.getInicio() != null && card.getTermino() != null){
			long milis = card.getTermino().getTime() - card.getInicio().getTime();
			card.setDuracao((int)(milis / (60*60*1000)));
		}
		
	}
}
