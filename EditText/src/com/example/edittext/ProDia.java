package com.example.edittext;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProDia extends Activity implements OnClickListener{
	
	private Button b1,b2,back;
	int m_count = 0;
	ProgressDialog m_pDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.prodia);
		
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		back = (Button)findViewById(R.id.button3);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		back.setOnClickListener(this);
		
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			
			m_pDialog = new ProgressDialog(ProDia.this);
			m_pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);  //设置进度条风格 圆形 旋转
			m_pDialog.setTitle("提示");
			m_pDialog.setMessage("这是一个圆形进度条对话框");
			m_pDialog.setIcon(R.drawable.ic_vm_sound_on_dk);
			m_pDialog.setIndeterminate(false);
			m_pDialog.setCancelable(true);
			m_pDialog.setButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			m_pDialog.show();
			
			break;
		case R.id.button2:
			
			m_count = 0;
			m_pDialog = new ProgressDialog(ProDia.this);
			m_pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  //设置进度条风格 长条形
			m_pDialog.setTitle("提示");
			m_pDialog.setMessage("这是一个长条进度条对话框");
			m_pDialog.setIcon(R.drawable.ic_vm_sound_off_dk);
			m_pDialog.setProgress(100);
			m_pDialog.setIndeterminate(false);
			m_pDialog.setCancelable(true);
			m_pDialog.setButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			m_pDialog.show();
			
			new Thread(){
				public void run(){
					try{
						while(m_count <=100){
							m_pDialog.setProgress(m_count++);
							Thread.sleep(1000);
						}
						m_pDialog.cancel();
					}catch(InterruptedException e){
						m_pDialog.cancel();
					}
				}
			}.start();
			
			
			break;
		case R.id.button3:
			Intent toMain = new Intent(ProDia.this,MainActivity.class);
			startActivity(toMain);
			ProDia.this.finish();
			break;
		}
	}
}
