package com.example.fortestensure;
/**
 * 
 * @author chenjianwei
 * 
 * 礼物类
 * 
 */
public class GiftData {
	int price; //礼物价格
	int picId; //礼物图片id
	String name; //礼物名称
	String desc; // 礼物描述
	
	public GiftData(String name, int picId,int price, String desc){
		this.name = name;
		this.picId = picId;
		this.price = price;
		this.desc = desc;
	}
	
	public GiftData() {
		// TODO Auto-generated constructor stub
	}

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
