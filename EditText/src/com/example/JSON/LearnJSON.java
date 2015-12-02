package com.example.JSON;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONException;
import org.json.JSONTokener;

import com.example.edittext.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LearnJSON extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json);
		
		Log.i("Andy", "----------------JSONObject-------------------------------------");
		
		// ��������Ҫ��������һ��json�ı�   person
	//  {  
//	      "phone" : ["12345678", "87654321"], // ����  
//	      "name" : "yuanzhifei89", // �ַ���  
//	      "age" : 100, // ��ֵ  
//	      "address" : { "country" : "china", "province" : "jiangsu" }, // ����  
//	      "married" : false // ����ֵ  
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
			
			x = obj.getString("����");
			Log.i("Andy", x);
			
			x = obj.getString("�Ա�");
			Log.i("Andy", x);
			
			x = obj.getString("����");
			Log.i("Andy", x);
			
			JSONObject obj1 = obj.getJSONObject("ѧϰ�ɼ�");
			x = obj1.getString("��ѧ");
			Log.i("Andy", x);
			
			x = obj1.getString("����");
			Log.i("Andy", x);
			
			x = obj1.getString("Ӣ��");
			Log.i("Andy", x);
			
			JSONArray array = obj1.getJSONArray("�ۺ�");
			obj = array.getJSONObject(0);
			x = obj.getString("�Ŀ��ۺ�");
			Log.i("Andy", x);
			
			obj = array.getJSONObject(1);
			x = obj.getString("����ۺ�");
			Log.i("Andy", x);
			
			JSONStringer s = new JSONStringer();
			Log.i("Andy", s.object().key("a").value("aaa").endObject().toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
