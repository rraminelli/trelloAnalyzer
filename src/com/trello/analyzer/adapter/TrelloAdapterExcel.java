package com.trello.analyzer.adapter;

import java.io.File;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.trello.analyzer.bean.Card;
import com.trello.analyzer.bean.List;
import com.trello.analyzer.bean.TrelloAnalyzer;

public class TrelloAdapterExcel extends AbstractTrelloAdapter {

	@Override
	protected String toAnalyserAdapter(TrelloAnalyzer trelloAnalyzer) {
		
		String filename = trelloAnalyzer.getTrello().getName()+".xls";
		
		try {
			
			
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("pt", "BR"));
			WritableWorkbook workbook = 
	        Workbook.createWorkbook(new File(filename), ws);
	      
			int i=0;
			for (List l : trelloAnalyzer.getTrello().getLists()) {
				WritableSheet s = workbook.createSheet(l.getName(),i++);
				writeDataSheet(s, trelloAnalyzer.getLists().get(l.getId()));			
			}
	      
			WritableSheet s = workbook.createSheet("Análise",i++);
			s.addCell(new jxl.write.Label(0, 0, "Análise"));
			
			workbook.write();
			workbook.close();
			
	    } catch (Exception e){
	    	e.printStackTrace();
	    }
		
		
		return filename;
	}

	private void writeDataSheet(WritableSheet s, java.util.List<Card> cards) throws Exception {
		
		/* Formata a fonte - Titulos */
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		
		/* Formata a fonte - Conteúdo */
		WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 10);
		WritableCellFormat cf2 = new WritableCellFormat(wf2);
		cf2.setWrap(true);
		
		WritableCellFormat cfDate = new WritableCellFormat(DateFormats.FORMAT9);		
		
		//Adiciona as Colunas
		s.addCell(new jxl.write.Label(0, 0, "Atividade", cf));
		s.addCell(new jxl.write.Label(1, 0, "Tipo", cf));
		s.addCell(new jxl.write.Label(2, 0, "Previsão Término", cf));
		s.addCell(new jxl.write.Label(3, 0, "Início", cf));
		s.addCell(new jxl.write.Label(4, 0, "Término", cf));
		s.addCell(new jxl.write.Label(5, 0, "Duração", cf));
		s.addCell(new jxl.write.Label(6, 0, "Status", cf));
		s.addCell(new jxl.write.Label(7, 0, "Observação", cf));
		
		int r = 1;
		for (Card card : cards) {
				
			s.addCell(new jxl.write.Label(0, r, card.getName(), cf2));
			s.addCell(new jxl.write.Label(1, r, card.getLabels().get(0).getName(), cf2));
			s.addCell(new jxl.write.Label(2, r, "", cf2));
			
			if(card.getInicio()!=null)
				s.addCell(new DateTime(3, r, card.getInicio(), cfDate, DateTime.GMT));
			else
				s.addCell(new jxl.write.Label(3, r, "", cf2));
			
			if(card.getTermino()!=null)
				s.addCell(new DateTime(4, r, card.getTermino(), cfDate, DateTime.GMT));
			else
				s.addCell(new jxl.write.Label(4, r, "", cf2));
			
			s.addCell(new jxl.write.Label(5, r, String.valueOf(card.getDuracao()), cf2));
			s.addCell(new jxl.write.Label(6, r, String.valueOf(card.getStatus()), cf2));
			s.addCell(new jxl.write.Label(7, r, card.getObservacao(), cf2));
			
			r++;
		}
			    
	}
	
}
