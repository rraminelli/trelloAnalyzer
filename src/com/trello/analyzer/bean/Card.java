package com.trello.analyzer.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Card {

	private String closed;
	private String name;
	private String desc;
	private String idList;
	
	private int status;
	private Date inicio;
	private Date termino;
	private int duracao;
	private String observacao;
	
	private List<Label> labels = new ArrayList<Label>();

	public String getClosed() {
		return closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getIdList() {
		return idList;
	}

	public void setIdList(String idList) {
		this.idList = idList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Card [closed=" + closed + ", name=" + name + ", desc=" + desc
				+ ", idList=" + idList + ", status=" + status + ", inicio="
				+ inicio + ", termino=" + termino + ", duracao=" + duracao
				+ ", labels=" + labels + "]";
	}

	
	
	
}
