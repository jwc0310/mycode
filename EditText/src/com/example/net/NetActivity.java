package com.example.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.edittext.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NetActivity extends Activity implements OnClickListener {

	private Button java,apache,android,kind;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net_main);
		
		InitAndBindEvent();
	}
	
	private void InitAndBindEvent(){
		java = (Button)findViewById(R.id.java);
		java.setOnClickListener(this);
		
		apache = (Button)findViewById(R.id.apache);
		apache.setOnClickListener(this);
		
		android = (Button)findViewById(R.id.android);
		android.setOnClickListener(this);
		
		kind = (Button)findViewById(R.id.kind);
		kind.setOnClickListener(this);
	}
	
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.java:
			testJava();
			break;
		case R.id.apache:
			try {
				testApache();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.android:
			try {
				testAndroid();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case R.id.kind:
			startActivity(new Intent(NetActivity.this,NetUI.class));
			break;
			
		}
		
	}
	
	private void testJava(){
		try{
			
			URL url = new URL("http://192.168.61.110");
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			Log.i("Andy", "nRC1 = ");
			int nRC = http.getResponseCode();
			Log.i("Andy", "nRC = "+nRC);
			if(nRC == HttpURLConnection.HTTP_OK){
				InputStream is = http.getInputStream();
				
				Toast.makeText(this, "java connect net success !", Toast.LENGTH_SHORT).show();
			}
			
			
		}catch(Exception e){
			Toast.makeText(this, "java connect net fail !", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}
		
	}
	private void testApache() throws IOException{
		HttpClient hc = new DefaultHttpClient();
		HttpGet get= new HttpGet("http://www.baidu.com");
		
		HttpResponse rp = hc.execute(get);
		
		if(rp.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			
			InputStream is = rp.getEntity().getContent();
			
			Toast.makeText(this, "Apache connect net success !", Toast.LENGTH_SHORT).show();
		}
		
	}
	private void testAndroid() throws IOException{
		
		Toast.makeText(this, "Android didn't finish !", Toast.LENGTH_SHORT).show();
		
	}
	

	
	
	
}
