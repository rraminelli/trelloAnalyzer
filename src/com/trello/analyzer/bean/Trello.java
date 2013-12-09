package com.trello.analyzer.bean;

import java.util.ArrayList;
import java.util.List;

public class Trello {

	private String id;
	private String name;
	private String url;
	private LabelNames labelNames = new LabelNames();
	
	private List<Card> cards = new ArrayList<Card>();
	private List<com.trello.analyzer.bean.List> lists = new ArrayList<com.trello.analyzer.bean.List>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}	
	public List<com.trello.analyzer.bean.List> getLists() {
		return lists;
	}
	public void setLists(List<com.trello.analyzer.bean.List> lists) {
		this.lists = lists;
	}
	
	public LabelNames getLabelNames() {
		return labelNames;
	}
	public void setLabelNames(LabelNames labelNames) {
		this.labelNames = labelNames;
	}
	@Override
	public String toString() {
		return "Trello [id=" + id + ", name=" + name + ", url=" + url
				+ ", labelNames=" + labelNames + ", cards=" + cards
				+ ", lists=" + lists + "]";
	}
	
	
}
