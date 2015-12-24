package com.andy.utils.parsexml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.Context;

public class SAXParseXml implements ParseXml {

	Context context;
	public SAXParseXml(Context context){
		this.context = context;
	}
	
	@Override
	public List<River> parseXml(String filename) {
		// TODO Auto-generated method stub
		List<River> rivers = new ArrayList<River>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try{
			SAXParser parser = factory.newSAXParser();
			
			//获取事件源
			XMLReader xmlReader = parser.getXMLReader();
			
			//设置处理器
			RiverHandler handler = new RiverHandler();
			
			xmlReader.setContentHandler(handler);
			
			//解析xml文档
			xmlReader.parse(new InputSource(this.context.getAssets().open(filename)));
			
			rivers=handler.getList();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rivers;
	}

}
