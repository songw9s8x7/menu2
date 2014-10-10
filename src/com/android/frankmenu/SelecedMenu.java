package com.android.frankmenu;

public class SelecedMenu {
	private String name;
	private int price;
	public SelecedMenu(){
		this.name = " ";
		this.price = 0;
	}
	public SelecedMenu(String name,int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return name + " ";
	}
	
}
