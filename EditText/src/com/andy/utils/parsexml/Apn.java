package com.andy.utils.parsexml;

import java.io.Serializable;

public class Apn implements Serializable {
	
	public String carrier;
	public String apn;
	public String mcc;
	public String mnc;
	public String labtest;
	public String protocol;
	public String type;
	
	public Apn(){
		
	}
	
	public Apn(String a){
		this.carrier = a;
		this.apn = a;
		this.mcc = a;
		this.mnc = a;
		this.labtest = a;
		this.protocol = a;
		this.type = a;
	}
	
	public String getCarrier(){
		return carrier;
	}
	public void setCarrier(String carrier){
		this.carrier = carrier;
	}
	
	public String getApn(){
		return apn;
	}
	public void setApn(String apn){
		this.apn = apn;
	}
	
	public String getMcc(){
		return mcc;
	}
	public void setMcc(String mcc){
		this.mcc = mcc;
	}
	
	public String getMnc(){
		return mnc;
	}
	public void setMnc(String mnc){
		this.mnc = mnc;
	}
	
	public String getLabtest(){
		return labtest;
	}
	public void setLabtest(String labtest){
		this.labtest = labtest;
	}
	
	public String getProtocol(){
		return protocol;
	}
	public void setProtocol(String protocol){
		this.protocol = protocol;
	}
	
	public String getType(){
		return type;
	}
	public void setType(String type){
		this.type = type;
	}
	
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Carrier is "+carrier);
		sb.append(", apn is "+apn);
		sb.append(", mcc is "+mcc);
		sb.append(", mnc is "+mnc);
		sb.append(", labtest is "+labtest);
		sb.append(", protocol is "+protocol);
		sb.append(", type is "+type);
		
		return sb.toString();
	}
	
	
}
