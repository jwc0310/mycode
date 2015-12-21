package com.andy.utils.parsexml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.andy.utils.LG;

import android.content.Context;

public class DomParseXml {
	
	
	Context context;
	
	public DomParseXml(Context context){
		this.context = context;
		LG.i(getClass(), context.toString());
	}
	
	/*
	 * ����DOM����ʱ���崦�����ǣ�
		1 ��������DocumentBuilderFactory����һ��DocumentBuilderFactoryʵ��
		2 Ȼ������DocumentBuilderFactory����DocumentBuilder
		3 Ȼ�����XML�ĵ���Document��,
		4 Ȼ���ȡ�ĵ��ĸ����(Element)��
		5 Ȼ���ȡ������������ӽڵ���б�NodeList����
		6 Ȼ��ʹ���ٻ�ȡ�ӽڵ��б��е���Ҫ��ȡ�Ľ�㡣
	 * 
	 * 
	 */
	
	public List<River> ParseXmlWithDom(String fileName){
		
		LG.i(getClass(), "entry");
		List<River> rivers = new ArrayList<River>();
		
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document document = null;
		InputStream inputStream = null;

		//�����ҵ�xml�ļ�
		factory=DocumentBuilderFactory.newInstance();

		if(factory == null){
			LG.i(getClass(), "factory is null");
		}

		try{
			//�ҵ�xml,�����ĵ�
			builder = factory.newDocumentBuilder();
			
			if(builder == null){
				LG.i(getClass(), "builder is null");
			}

			inputStream = this.context.getResources().getAssets().open(fileName);
			if(inputStream == null){
				LG.i(getClass(), "inputStream is null");
			}

			document = builder.parse(inputStream);
			//�ҵ���Elements
			Element root = document.getDocumentElement();
			NodeList nodes = root.getElementsByTagName(River.RIVER);
			
			if(nodes == null){
				LG.i(getClass(), "nodes is null");
			}
			
			//�������ڵ������ӽڵ�,rivers������river
			River river= null;

			for(int i=0; i<nodes.getLength();i++){
				river = new River();

				//��ȡriverԪ�ؽڵ�
				Element riverElement = (Element)(nodes.item(i));
				//��ȡriver��name����ֵ
				river.setName(riverElement.getAttribute("name"));

				river.setLength(Integer.parseInt(riverElement.getAttribute("length")));
				
				//��ȡriver��introduction��ǩ
				Element intro=(Element)riverElement.getElementsByTagName("introduction").item(0);
				river.setIntroduction(intro.getFirstChild().getNodeValue());
				
				Element imageUrl=(Element)riverElement.getElementsByTagName("imageurl").item(0);
				river.setImageurl(imageUrl.getFirstChild().getNodeValue());
				
				rivers.add(river);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LG.i(getClass(), "exit");
			
		}
		
		return rivers;
		
	}
	
}
