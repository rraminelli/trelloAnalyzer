package com.trello.analyzer.adapter;

import com.trello.analyzer.bean.TrelloAnalyzer;

public class TrelloAdapterJsonHighcharts extends AbstractTrelloAdapter {

	public static final int TYPE_LISTS = 1;
	public static final int TYPE_TASKS_TYPE = 2;
	
	private int typeChart;
	
	@Override
	protected String toAnalyserAdapter(TrelloAnalyzer trelloAnalyzer) {
		
		if(getTypeChart() == TYPE_LISTS)
			
			return AdapterJsonHighchartsUtils.getChartLists(trelloAnalyzer);
		
		else if(getTypeChart() == TYPE_TASKS_TYPE)
			
			return AdapterJsonHighchartsUtils.getChartTasksType(trelloAnalyzer);
		
		else
			
			return "";
	}
	
	
	
	public int getTypeChart() {
		return typeChart;
	}

	public void setTypeChart(int typeChart) {
		this.typeChart = typeChart;
	}



	

}
