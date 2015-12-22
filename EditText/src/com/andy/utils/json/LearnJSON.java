package com.andy.utils.json;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONException;
import org.json.JSONTokener;

import com.andy.utils.LG;
import com.andy.utils.parsexml.DomParseXml;
import com.andy.utils.parsexml.ParseXml;
import com.andy.utils.parsexml.River;
import com.example.edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LearnJSON extends Activity implements OnClickListener{
	
	private final static int Update = 0;
	
	private ListView riverlist;
	private Button b_dom, b_sax, b_pull, b_clear;
	private static List<River> rivers = new ArrayList<River>();;
	private RiverAdapter adapter = new RiverAdapter(this,rivers);
	private final static String fileName = "river.xml";
	ParseXml px;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);

		px = new DomParseXml(this);
		
		b_dom = (Button)findViewById(R.id.dom);
		b_dom.setOnClickListener(this);
		b_sax = (Button)findViewById(R.id.sax);
		b_sax.setOnClickListener(this);
		b_pull = (Button)findViewById(R.id.pull);
		b_pull.setOnClickListener(this);
		b_clear = (Button)findViewById(R.id.clear);
		b_clear.setOnClickListener(this);

		//rivers = new ArrayList<River>();
		riverlist = (ListView)findViewById(R.id.river_list);
		riverlist.setAdapter(adapter);
		
		
		
		
		LG.i(getClass(), "----------------JSONObject-------");
		
		// 假设现在要创建这样一个json文本   person
	//  {  
//	      "phone" : ["12345678", "87654321"], // 数组  
//	      "name" : "yuanzhifei89", // 字符串  
//	      "age" : 100, // 数值  
//	      "address" : { "country" : "china", "province" : "jiangsu" }, // 对象  
//	      "married" : false // 布尔值  
	//  } 
		JSONObject person = new JSONObject();
		try {
			
			
			JSONArray phone = new JSONArray();
			phone.put("12345678").put("87654321");
			person.put("phone", phone);
			
			person.put("name", "Andy Chen");
			person.put("age", "100");
			
			JSONObject address = new JSONObject();
			address.put("country", "china");
			address.put("province", "henan");
			person.put("address", address);
			
			person.put("married", false);
			
			Log.i("Andy", person.toString());
			
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Log.i("Andy", "----------------JSONTokener-------------------------------------");
		
		final String JSON =
				"{" +  
				    "   \"phone\" : [\"12345678\", \"87654321\"]," +  
				    "   \"name\" : \"yuanzhifei89\"," +  
				    "   \"age\" : 100," +  
				    "   \"address\" : { \"country\" : \"china\", \"province\" : \"jiangsu\" }," +  
				    "   \"married\" : false," +  
				"}"; 
		try{
			JSONTokener jsonParser = new JSONTokener(person.toString());
			JSONObject person2 = (JSONObject)jsonParser.nextValue();
			Log.i("Andy", person2.getJSONArray("phone").toString());
			Log.i("Andy", person2.getString("name"));
			Log.i("Andy", String.valueOf(person2.getInt("age")));
			Log.i("Andy", person2.getJSONObject("address").toString());
			Log.i("Andy", String.valueOf(person2.getBoolean("married")));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Log.i("Andy", "----------------JSONStringer-------------------------------------");
		JSONStringer person1 = new JSONStringer();
		try {
			person1.object();
			
			person1.key("phone");
			person1.array();
			person1.value("12345678").value("87654321");
			person1.endArray();
			
			person1.key("name").value("Andy Chen");
			person1.key("age").value("100");
			
			person1.key("address");
			person1.object();
			person1.key("country").value("china");
			person1.key("province").value("henan");
			person1.endObject();
			
			person1.key("married").value(false);
			person1.endObject();
			
			Log.i("Andy", person1.toString());
			
		} catch (JSONException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		Log.i("Andy", "-----------------------------------------------------");
		
		JSONObject json2;
		try {
			json2 = new JSONObject().put("JSON", "--Andy--1");
			Log.i("Andy", json2.getString("JSON"));
			Log.i("Andy", json2.optString("JSON"));
			
			JSONStringer jsonStr = new JSONStringer();
			jsonStr.object().key("Andy").value("--Andy--2").endObject();
			Log.i("Andy", jsonStr.toString());
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String x;
		JSONObject obj;
		
		try{
			InputStream is = this.getResources().openRawResource(R.raw.json);
			
			byte [] buffer = new byte[is.available()];
			
			is.read(buffer);
			TextView v = new TextView(this);
			
			//String json = new String(buffer, "utf-8");
			//Log.i("Andy", json);
			
			String json = new String(buffer, "gb2312");
			//Log.i("Andy", json);
			obj = new JSONObject(json);
			
			x = obj.getString("姓名");
			Log.i("Andy", x);
			
			x = obj.getString("性别");
			Log.i("Andy", x);
			
			x = obj.getString("年龄");
			Log.i("Andy", x);
			
			JSONObject obj1 = obj.getJSONObject("学习成绩");
			x = obj1.getString("数学");
			Log.i("Andy", x);
			
			x = obj1.getString("语文");
			Log.i("Andy", x);
			
			x = obj1.getString("英语");
			Log.i("Andy", x);
			
			JSONArray array = obj1.getJSONArray("综合");
			obj = array.getJSONObject(0);
			x = obj.getString("文科综合");
			Log.i("Andy", x);
			
			obj = array.getJSONObject(1);
			x = obj.getString("理科综合");
			Log.i("Andy", x);
			
			JSONStringer s = new JSONStringer();
			Log.i("Andy", s.object().key("a").value("aaa").endObject().toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		LG.i(getClass(), String.valueOf(v.getId()));
		
		switch(v.getId()){
		case R.id.dom:
			rivers.addAll((Collection<? extends River>) px.parseXml(fileName));
			Message msg = new Message();
			msg.what = Update;
			myHandler.sendMessage(msg);
			break;
		case R.id.sax:
			break;
		case R.id.pull:
			break;
		case R.id.clear:
			rivers.clear();
			Message msg1 = new Message();
			msg1.what = Update;
			myHandler.sendMessage(msg1);
			break;
		}
	}
	
	Handler myHandler = new Handler(){
		public void handleMessage(Message msg){
			LG.i(getClass(), String.valueOf(msg.what));
			switch(msg.what){
			case Update:
				for(River obj: rivers){
					LG.i(getClass(), obj.getName());
					LG.i(getClass(), String.valueOf(obj.getLength()));
					LG.i(getClass(), obj.getIntroduction());
					LG.i(getClass(), obj.getImageurl());
				}
				adapter.notifyDataSetChanged();
				break;
			}
			super.handleMessage(msg);
		}
		
	};
	
}
