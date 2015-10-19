package com.example.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.edittext.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity02 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);
		
		TextView mtv = (TextView)findViewById(R.id.textView_http);
		
		String httpUrl = "http://127.0.0.1/http1.jst";
		
		String resultData = "";
		URL url = null;
		
		try{
			url = new URL(httpUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(url != null){
			try{
				//open link
				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
				//get content stream
				InputStreamReader in = new InputStreamReader(urlConn.getInputStream());
				
				//´´½¨Êä³öbufferReder
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				
				while(((inputLine = buffer.readLine())!=null)){
					resultData += inputLine +"\n";
				}
				
				in.close();
				urlConn.disconnect();
				
				if(resultData != null){
					mtv.setText(resultData);
				}else{
					mtv.setText("null");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			Log.e("Andy", "url null");
		}
		
		
		Button b_back = (Button)findViewById(R.id.button_back);
		b_back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Activity02.this,NetUI.class));
				Activity02.this.finish();
			}
			
		});
		
		
	}
	
	
	
	
	
}
