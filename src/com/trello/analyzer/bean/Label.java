package com.trello.analyzer.bean;

public class Label {

	private String color;
	private String name;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Label [color=" + color + ", name=" + name + "]";
	}
	
	
	
}
