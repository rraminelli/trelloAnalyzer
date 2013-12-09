package com.trello.analyzer.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trello.analyzer.adapter.AbstractTrelloAdapter;
import com.trello.analyzer.adapter.TrelloAdapterJsonHighcharts;

public class ChartsServlet extends HttpServlet {

	private static final long serialVersionUID = 8543789292140815556L;


	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String arquivo = req.getRealPath("")+"/json/tm-portal-captacao-de-arquivos.json";
		
		try {
			String type = req.getParameter("type");
			
			AbstractTrelloAdapter trelloAdapter = new TrelloAdapterJsonHighcharts();
			
			if("lists".equals(type)){
				
				((TrelloAdapterJsonHighcharts)trelloAdapter).setTypeChart(TrelloAdapterJsonHighcharts.TYPE_LISTS);
				
			} else if("tasksType".equals(type)){
				
				((TrelloAdapterJsonHighcharts)trelloAdapter).setTypeChart(TrelloAdapterJsonHighcharts.TYPE_TASKS_TYPE);
				
			}
			
			String json = trelloAdapter.toAnalyzer(new File(arquivo));
			
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.print(json);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
