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
		
		//��ȡXmlPullParser������
		XmlPullParser xmlParser = Xml.newPullParser();
		try{
			//�õ��ļ����������ñ��뷽ʽ
			inputStream = this.context.getResources().getAssets().open(filename);
			xmlParser.setInput(inputStream, "utf-8");
			
			//��ý��������¼���𣬿�ʼ�ĵ��������ĵ�����ʼ��ǩ��������ǩ���ı��ȵ��¼�
			int eventType = xmlParser.getEventType();
			
			//һֱѭ��ֱ���ĵ�����
			while(eventType != XmlPullParser.END_DOCUMENT){
				switch(eventType){
				case XmlPullParser.START_TAG:
					
					String tag = xmlParser.getName();
					//�����river��ǩ��ʼ����˵��Ҫʵ����������
					if(tag.equalsIgnoreCase("river")){
						river = new River();
						//��river��ȥ������ֵ
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
					 //�������river��ǩ���������river������ӽ�������
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
