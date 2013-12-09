package com.trello.analyzer.adapter;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.trello.analyzer.bean.List;
import com.trello.analyzer.bean.TrelloAnalyzer;

public abstract class AdapterJsonHighchartsUtils {

	public static String getChartLists(TrelloAnalyzer trelloAnalyzer) {
		
		java.util.List<JsonCharts> dataCharts = new ArrayList<JsonCharts>();
		
		for (List l : trelloAnalyzer.getTrello().getLists()) {
			
			JsonCharts json = new JsonCharts();
			//json.setColor(color);
			json.setName(l.getName());
			json.setY(Float.valueOf(trelloAnalyzer.getLists().get(l.getId()).size()));
			dataCharts.add(json);
			
		}
		
		return new Gson().toJson(dataCharts);
		
	}
	
	public static String getChartTasksType(TrelloAnalyzer trelloAnalyzer) {
		
		java.util.List<JsonCharts> dataCharts = new ArrayList<JsonCharts>();
		
		JsonCharts json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getBlue());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("blue").size()));
		dataCharts.add(json);
		
		json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getGreen());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("green").size()));
		dataCharts.add(json);
		
		json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getOrange());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("orange").size()));
		dataCharts.add(json);
		
		json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getPurple());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("purple").size()));
		dataCharts.add(json);
		
		json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getRed());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("red").size()));
		dataCharts.add(json);
		
		json = new JsonCharts();
		//json.setColor(color);
		json.setName(trelloAnalyzer.getTrello().getLabelNames().getYellow());
		json.setY(Float.valueOf(trelloAnalyzer.getColors().get("yellow").size()));
		dataCharts.add(json);
		
		
		return new Gson().toJson(dataCharts);
		
	}
	
}

 class JsonCharts {
	
	private String name;
	//private String color;
	private Float y;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Float getY() {
		return y;
	}
	public void setY(Float y) {
		this.y = y;
	}
	
}
