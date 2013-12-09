package com.trello.analyzer.tester;

import java.util.List;

import com.trello.analyzer.adapter.AbstractTrelloAdapter;
import com.trello.analyzer.adapter.TrelloAdapterJsonHighcharts;

public class TestChart {

	public static void main(String[] args) throws Exception {
		
		AbstractTrelloAdapter trelloAdapter = new TrelloAdapterJsonHighcharts();
		List<String> result = trelloAdapter.printDataTrelloAllFilesJson();

		for (String string : result) {
			System.out.println(string);
		}
	}

}
