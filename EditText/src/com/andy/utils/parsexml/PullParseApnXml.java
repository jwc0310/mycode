package com.andy.utils.parsexml;

import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.andy.utils.LG;

import android.content.Context;
import android.util.Xml;

public class PullParseApnXml implements ParseXml {

	private Context context;
	private List<Apn> list;
	public PullParseApnXml(Context context,List<Apn> list){
		this.context = context;
		this.list = list;
	}
	
	@Override
	public List<Apn> parseXml(String filename) {
		// TODO Auto-generated method stub
		
		Apn apn = null;
		InputStream is = null;
		
		XmlPullParser xmlParser = Xml.newPullParser();
		try{
			
			is = this.context.getResources().getAssets().open(filename);
			xmlParser.setInput(is,"utf-8");
			
			int eventType = xmlParser.getEventType();
			
			
			while(eventType != XmlPullParser.END_DOCUMENT){
				//LG.i(getClass(), "eventType = "+eventType);
				
				switch(eventType){
				case XmlPullParser.START_TAG:
					String tag = xmlParser.getName();
					//LG.i(getClass(), "tag = "+tag);
					
					if(tag.equalsIgnoreCase("apn")){
						apn = new Apn();
						apn.setCarrier(xmlParser.getAttributeValue(0));
						apn.setApn(xmlParser.getAttributeValue(1));
						apn.setMcc(xmlParser.getAttributeValue(2));
						apn.setMnc(xmlParser.getAttributeValue(3));
						apn.setLabtest(xmlParser.getAttributeValue(4));
						apn.setProtocol(xmlParser.getAttributeValue(5));
						apn.setType(xmlParser.getAttributeValue(6));
						//LG.i(getClass(), apn.toString());
					}
					break;
					
				case XmlPullParser.END_TAG:
					if(apn != null){
						list.add(apn);
						apn = null;
					}else{
						LG.i(getClass(), "apn is null");
					}
					
					break;
				}
				
				eventType = xmlParser.next();
				
			}
			return list;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

}
