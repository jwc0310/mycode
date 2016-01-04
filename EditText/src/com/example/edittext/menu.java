package com.example.edittext;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.andy.utils.LG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menu extends Activity {

	public static final int SHOW_RESPONSE=0;
	
	Button httpUrl;
	Button httpClient;
	TextView tv;
	
	private Handler httpHandler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			
			switch(msg.what){
			case SHOW_RESPONSE:
				String response = (String)msg.obj;
				tv.setText(response);
				break;
			default:
				break;
			}
		}
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menumain);
		
		httpUrl = (Button)findViewById(R.id.HttpUrlConnection);
		httpClient = (Button)findViewById(R.id.HttpClient);
		tv = (TextView)findViewById(R.id.response_text);
		
	}
	
	public void httpUrlOnClick(View view){
		LG.i(getClass(), "httpUrlOnClick()");
		sendRequestWithHttpURLConnection();
		
	}
	public void httpClientOnClick(View view){
		LG.i(getClass(), "httpClientOnClick()");
		sendRequestWithHttpClient();
	}
	private void sendRequestWithHttpClient(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					HttpClient httpClient = new DefaultHttpClient();
					HttpGet httpGet = new HttpGet("http://www.baidu.com");
					HttpResponse httpR = httpClient.execute(httpGet);
					
					if(httpR.getStatusLine().getStatusCode() == 200){
						//请求和响应都成功了
						HttpEntity entity=httpR.getEntity();
                        String response=EntityUtils.toString(entity,"utf-8");
						
						Message msg = new Message();
						msg.what = SHOW_RESPONSE;
						msg.obj = response.toString();
						
						httpHandler.sendMessage(msg);
						
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}).start();
	}
	
	private void sendRequestWithHttpURLConnection(){
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				HttpURLConnection conn = null;
				try{
					URL url = new URL("http://www.baidu.com");
					conn = (HttpURLConnection)url.openConnection();
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(8000);
					conn.setReadTimeout(8000);
					
					InputStream in = conn.getInputStream();
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while((line=reader.readLine())!=null){
						response.append(line);
					}
					Message msg = new Message();
					msg.what = SHOW_RESPONSE;
					msg.obj = response.toString();
					
					httpHandler.sendMessage(msg);
					
					in.close();
					//conn.disconnect();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					if(conn != null){
						conn.disconnect();
					}
				}
			}
			
		}).start();
	}
	
	
	
	//create menu
	public boolean onCreateOptionsMenu(Menu menu){
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		Log.i("Andy", "menu show!");
		return true;
	}
	
	// deal with menu event
	public boolean onOptionsItemSelected(MenuItem item){
		// TODO Auto-generated method stub 
		switch(item.getItemId()){
		
		case R.id.about:
			Intent intent = new Intent();
			intent.setClass(menu.this, menu1.class);
			startActivity(intent);
			menu.this.finish();
			
			break;
		case R.id.exit:
			menu.this.finish();
			
			break;
		}
		return true;
	}
	
	
}
