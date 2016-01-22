package com.andy.utils.parsexml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.content.Context;
import android.util.Xml;

public class PullParseXml implements ParseXml {

	private Context context;
	public PullParseXml(Context context){
		this.context = context;
	}
	
	@Override
	public List<River> parseXml(String filename) {
		// TODO Auto-generated method stub
		List<River> rivers = new ArrayList<River>();
		
		River river = null;
		InputStream inputStream = null;
		
		//获取XmlPullParser解析器
		XmlPullParser xmlParser = Xml.newPullParser();
		try{
			//得到文件流，并设置编码方式
			inputStream = this.context.getResources().getAssets().open(filename);
			xmlParser.setInput(inputStream, "utf-8");
			
			//获得解析到的事件类别，开始文档，结束文档，开始标签，结束标签，文本等等事件
			int eventType = xmlParser.getEventType();
			
			//一直循环直到文档结束
			while(eventType != XmlPullParser.END_DOCUMENT){
				switch(eventType){
				case XmlPullParser.START_TAG:
					
					String tag = xmlParser.getName();
					//如果是river标签开始，则说明要实例化对象了
					if(tag.equalsIgnoreCase("river")){
						river = new River();
						//从river中去除属性值
						river.setName(xmlParser.getAttributeValue(null, "name"));
						river.setLength(Integer.parseInt(xmlParser.getAttributeValue(null, "length")));
					}else if(river != null){
						if(tag.equalsIgnoreCase("introduction")){
							river.setIntroduction(xmlParser.nextText());
						}else if(tag.equalsIgnoreCase("imageurl")){
							river.setImageurl(xmlParser.nextText());
						}
					}
					
					break;
				case XmlPullParser.END_TAG:
					 //如果遇到river标签结束，则把river对象添加进集合中
					if(xmlParser.getName().equalsIgnoreCase("river") && river != null){
						rivers.add(river);
						river = null;
					}
					break;
					
				default:
					break;
					
				}
				eventType = xmlParser.next();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rivers;
	}

}
