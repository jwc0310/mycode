package com.example.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.edittext.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity03 extends Activity {
	private final String DEBUG_TAG = "Activity03"; 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);	
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
            .detectDiskReads().detectDiskWrites().detectNetwork()  
            .penaltyLog().build());  
  
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  
            .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()  
            .build());
		}
		
		TextView mTextView = (TextView)this.findViewById(R.id.textView_http);
		//http地址"?par=abcdefg"是我们上传的参数
		String httpUrl = "http://192.168.61.110:8080/httpget.jsp?par=abcdefg";
		//获得的数据
		String resultData = "";
		URL url = null;
		try
		{
			//构造一个URL对象
			url = new URL(httpUrl); 
		}
		catch (MalformedURLException e)
		{
			Log.e(DEBUG_TAG, "MalformedURLException");
		}
		if (url != null)
		{
			try
			{
				// 使用HttpURLConnection打开连接
				HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
				//得到读取的内容(流)
				InputStreamReader in = new InputStreamReader(urlConn.getInputStream());
				// 为输出创建BufferedReader
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				//使用循环来读取获得的数据
				while (((inputLine = buffer.readLine()) != null))
				{
					//我们在每一行后面加上一个"\n"来换行
					resultData += inputLine + "\n";
				}		  
				//关闭InputStreamReader
				in.close();
				//关闭http连接
				urlConn.disconnect();
				//设置显示取得的内容
				if ( resultData != null )
				{
					mTextView.setText(resultData);
				}
				else 
				{
					mTextView.setText("读取的内容为NULL");
				}
			}
			catch (IOException e)
			{
				Log.e(DEBUG_TAG, "IOException");
			}
		}
		else
		{
			Log.e(DEBUG_TAG, "Url NULL");
		}
		Button button_Back = (Button) findViewById(R.id.button_back);
		/* 监听button的事件信息 */
		button_Back.setOnClickListener(new Button.OnClickListener() 
		{
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(Activity03.this, NetUI.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				Activity03.this.finish();
			}
		});
	}
}
