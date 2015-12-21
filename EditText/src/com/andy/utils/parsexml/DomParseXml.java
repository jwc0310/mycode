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
	 * 采用DOM解析时具体处理步骤是：
		1 首先利用DocumentBuilderFactory创建一个DocumentBuilderFactory实例
		2 然后利用DocumentBuilderFactory创建DocumentBuilder
		3 然后加载XML文档（Document）,
		4 然后获取文档的根结点(Element)，
		5 然后获取根结点中所有子节点的列表（NodeList），
		6 然后使用再获取子节点列表中的需要读取的结点。
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

		//首先找到xml文件
		factory=DocumentBuilderFactory.newInstance();

		if(factory == null){
			LG.i(getClass(), "factory is null");
		}

		try{
			//找到xml,加载文档
			builder = factory.newDocumentBuilder();
			
			if(builder == null){
				LG.i(getClass(), "builder is null");
			}

			inputStream = this.context.getResources().getAssets().open(fileName);
			if(inputStream == null){
				LG.i(getClass(), "inputStream is null");
			}

			document = builder.parse(inputStream);
			//找到根Elements
			Element root = document.getDocumentElement();
			NodeList nodes = root.getElementsByTagName(River.RIVER);
			
			if(nodes == null){
				LG.i(getClass(), "nodes is null");
			}
			
			//遍历根节点所有子节点,rivers下所有river
			River river= null;

			for(int i=0; i<nodes.getLength();i++){
				river = new River();

				//获取river元素节点
				Element riverElement = (Element)(nodes.item(i));
				//获取river中name属性值
				river.setName(riverElement.getAttribute("name"));

				river.setLength(Integer.parseInt(riverElement.getAttribute("length")));
				
				//获取river下introduction标签
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
