package com.andy.utils.parsexml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.andy.utils.LG;

public class RiverHandler extends DefaultHandler {

	List<River> list;
	River river = null;
	int currentState = 0;
	final int intr = 1;
	final int url = 2;

	public List<River> getList() {
		return list;
	}
	/*
	 * 文档开始通知
	 */
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		list = new ArrayList<River>();
	}

	/*
	 * 标签开始通知
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		LG.i(getClass(), "[startElement]: "+uri+","+localName+","+qName);
		if(localName.equals("rivers")){
			currentState = 0;
			return;
		}
		if(localName.equals("river")){
			river = new River();
			for(int i = 0; i<attributes.getLength();i++){
				LG.i(getClass(), "[startElement-attributes]: "+attributes.getLocalName(i));
				if (attributes.getLocalName(i).equals("name")) {
					river.setName(attributes.getValue(i));
				} else if (attributes.getLocalName(i).equals("length")) {
					river.setLength(Integer.parseInt(attributes.getValue(i)));
				}
			}
			return;
		}
		if(localName.equals("introduction")){
			LG.i(getClass(), "[startElement]: "+currentState+"->"+intr);
			currentState = intr;
			return;
		}
		if(localName.equals("imageurl")){
			LG.i(getClass(), "[startElement]: "+currentState+"->"+url);
			currentState = url;
			return;
		}
		//currentState = 0;
	}
	
	/*
	 * 接口字符块通知
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		// super.characters(ch, start, length);
		String theString = String.valueOf(ch, start, length).trim();
		//or
		//String theString = new String(ch, start, length).trim();
		LG.i(getClass(), "[characters]: "+currentState+",-"+theString);
		
		if(theString == null || theString.length() <= 0){
			return;
		}
		switch(currentState){
		case intr:
			river.setIntroduction(theString);
			LG.i(getClass(), "[characters]: "+currentState+"->"+0);
			currentState = 0;
			break;
		case url:
			river.setImageurl(theString);
			LG.i(getClass(), "[characters]: "+currentState+"->"+0);
			currentState = 0;
			break;
		default:
			return;
			
		}
	}
	
	/*
	 * 接收标签结束通知
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		LG.i(getClass(), "[endElement]: "+uri+","+localName+","+qName);
		if (localName.equals("river")){
			list.add(river);
			river = null;
		}
	}
	
	/*
	 * 接收文档结束通知
	 */
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}


}
