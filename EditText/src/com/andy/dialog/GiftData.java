package com.andy.dialog;

public class GiftData {
	int price;
	int picId;
	String name;
	String desc;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setId(int picId){
		this.picId = picId;
	}
	
	public int getId(){
		return picId;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public int getPrice(){
		return price;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return desc;
	}
}
