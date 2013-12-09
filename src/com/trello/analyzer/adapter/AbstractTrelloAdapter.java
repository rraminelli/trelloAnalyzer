package com.trello.analyzer.adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.trello.analyzer.bean.Trello;
import com.trello.analyzer.bean.TrelloAnalyzer;

public abstract class AbstractTrelloAdapter {

	public List<String> printDataTrelloAllFilesJson() throws Exception {
		
		List<String> ret = new ArrayList<String>();
		
		File[] files = filesAllJson();
		for (File file : files) {
			ret.add(toAnalyzer(file));
		}
		
		return ret;
		
	}
	
	public String toAnalyzer(File file) throws Exception {
		
		Trello trello = analyzerFile(file);
		TrelloAnalyzer trelloAnalyzer = analyzerObject(trello);
		String analyze = toAnalyserAdapter(trelloAnalyzer);
		
		return analyze;
		
	}
	
	protected File[] filesAllJson() throws Exception{
		
		FilenameFilter filter = new FilenameFilter() {
	        public boolean accept(File directory, String fileName) {
	            return fileName.endsWith(".json");
	        }
		};
		
		File[] files = new File(".").listFiles(filter);
		
		return files;
		
	}
	
	protected Trello analyzerFile(File file) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		StringBuilder str = new StringBuilder("");
		while (in.ready()) {
			str.append(in.readLine());		
		}
		in.close();

		Gson gson = new Gson();
		Trello trello = gson.fromJson(str.toString(), Trello.class);
		
		return trello;
	}
	
	protected TrelloAnalyzer analyzerObject(Trello trello) {
		
		return TrelloReader.getInstance().formatObject(trello);
		
	}
	
	protected abstract String toAnalyserAdapter(TrelloAnalyzer trelloAnalyzer);
	
}
