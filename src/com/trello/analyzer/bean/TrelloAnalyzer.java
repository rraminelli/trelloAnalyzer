package com.trello.analyzer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TrelloAnalyzer {

	//Testes
	public static final String TIPO_TESTE = "#Teste:Teste#";
	public static final String TIPO_TESTE_FALHA = "#Teste:Falha:Teste#";
	public static final String TIPO_TESTE_SUCESSO = "#Teste:Ok:Teste#";
	//Categorias de erro
	public static final String TIPO_TESTE_FALHA_MUDANCA = "#Teste:Falha:Change:Teste#";
	public static final String TIPO_TESTE_FALHA_REQUISITO = "#Teste:Falha:Requisito:Teste#";
	public static final String TIPO_TESTE_FALHA_CODIFICACAO = "#Teste:Falha:Codificacao:Teste#";
	public static final String TIPO_TESTE_FALHA_INFRA = "#Teste:Falha:Infra:Teste#";
	public static final String TIPO_TESTE_FALHA_INTEGRACAO = "#Teste:Falha:Integracao:Teste#";
		
	private Map<String, java.util.List<Card>> lists = new HashMap<String, java.util.List<Card>>();
	private Map<String, java.util.List<Card>> colors = new HashMap<String, java.util.List<Card>>();
	private Map<String, java.util.List<Card>> tests = new HashMap<String, java.util.List<Card>>();
	
	private Trello trello;
	
	public TrelloAnalyzer() {
		//Incializa o map de cores
		colors.put("yellow", new ArrayList<Card>());
		colors.put("red", new ArrayList<Card>());
		colors.put("purple", new ArrayList<Card>());
		colors.put("orange", new ArrayList<Card>());
		colors.put("green", new ArrayList<Card>());
		colors.put("blue", new ArrayList<Card>());
		
		tests.put(TIPO_TESTE, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA, new ArrayList<Card>());
		tests.put(TIPO_TESTE_SUCESSO, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA_MUDANCA, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA_REQUISITO, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA_CODIFICACAO, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA_INFRA, new ArrayList<Card>());
		tests.put(TIPO_TESTE_FALHA_INTEGRACAO, new ArrayList<Card>());
	}

	public Map<String, java.util.List<Card>> getLists() {
		return lists;
	}

	public void setLists(Map<String, java.util.List<Card>> lists) {
		this.lists = lists;
	}

	public Map<String, java.util.List<Card>> getColors() {
		return colors;
	}

	public void setColors(Map<String, java.util.List<Card>> colors) {
		this.colors = colors;
	}

	public Map<String, java.util.List<Card>> getTests() {
		return tests;
	}

	public void setTests(Map<String, java.util.List<Card>> tests) {
		this.tests = tests;
	}

	public Trello getTrello() {
		return trello;
	}

	public void setTrello(Trello trello) {
		this.trello = trello;
	}

	
	
	
}
