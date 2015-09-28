package com.example.edittext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class Probar extends Activity {

	private ProgressBar m_pb1,m_pb2;
	private Button m_b1,m_b2;
	protected static final int GUI_STOP_NOTIFIER = 0x108;
	protected static final int GUI_TREADING_NOTIFIER = 0x109;
	public int intCounter=0;
	private Thread myThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//设置窗口模式，因为需要显示进度条在标题栏
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setProgressBarVisibility(true);
		setContentView(R.layout.probar);
		
		m_pb1 = (ProgressBar)findViewById(R.id.ProgressBar01);
		m_pb2 = (ProgressBar)findViewById(R.id.ProgressBar02);
		
		m_b1 = (Button)findViewById(R.id.Button01);
		m_b2 = (Button)findViewById(R.id.Button02);
		
		m_b1.setOnClickListener(b_event);
		m_b2.setOnClickListener(b_event);
		
		
	}
	Runnable myRun = new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<10;i++){
				try{
					intCounter = (i+1)*20;
					Thread.sleep(1000);
					if(i == 4){
						Message message = new Message();
						message.what = Probar.GUI_STOP_NOTIFIER;
						Probar.this.myMessageHandler.sendMessage(message);
					}else{
						Message message = new Message();
						message.what = Probar.GUI_TREADING_NOTIFIER;
						Probar.this.myMessageHandler.sendMessage(message);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	};
	
	View.OnClickListener b_event = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.Button01:
				m_pb1.setVisibility(View.VISIBLE);
				m_pb2.setVisibility(View.VISIBLE);
				
				m_pb1.setMax(100);
				m_pb1.setProgress(0);
				m_pb2.setProgress(0);
				
				myThread = new Thread(myRun);
				myThread.start();
				
				break;
			case R.id.Button02:
				Intent intent = new Intent();
				intent.setClass(Probar.this, MainActivity.class);
				startActivity(intent);
				Probar.this.finish();
				break;
			}
		}
	};
	
	Handler myMessageHandler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case Probar.GUI_STOP_NOTIFIER:
				m_pb1.setVisibility(View.GONE);
				m_pb2.setVisibility(View.GONE);
				Thread.currentThread().interrupt();
				break;
			case Probar.GUI_TREADING_NOTIFIER:
				if(!Thread.currentThread().isInterrupted()){
					m_pb1.setProgress(intCounter);
					m_pb2.setProgress(intCounter);
					
					//set titile bar 
					setProgress(intCounter*100);
					setSecondaryProgress(intCounter*100);
					break;
				}
				
				super.handleMessage(msg);
				
				
			}
		}
	};
	
	
	
	
}
