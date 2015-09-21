package com.example.edittext;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LearnDialog extends Activity{

	ProgressDialog m_Dialog;
	Button back;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_main);
		
		back = (Button)findViewById(R.id.button1);
		
		
		
		Dialog dialog = new AlertDialog.Builder(LearnDialog.this)
			.setTitle("��¼��ʾ")
			.setMessage("������Ҫ��¼��")
			.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					//���ȷ��
					LayoutInflater fac = LayoutInflater.from(LearnDialog.this);
					final View DialogView = fac.inflate(R.layout.dialog,null);
					//Create dialog
					AlertDialog dlg = new AlertDialog.Builder(LearnDialog.this)
						.setTitle("��¼��")
						.setView(DialogView)
						.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								m_Dialog = ProgressDialog.show(LearnDialog.this, "��ȴ�...","���ڵ�¼...",true);
								
								
								new Thread(){
									public void run(){
										try{
											sleep(3000);
										}catch(Exception e){
											e.printStackTrace();
										}finally{
											m_Dialog.dismiss();
										}
									}
								}.start();
							}
						})
						.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
				
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								LearnDialog.this.finish();
							}
						})
						.create();
					dlg.show();
				}
			}).setNeutralButton("�˳�", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					LearnDialog.this.finish();
				}
			}).create();
		dialog.show();
		
		
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent toMain = new Intent();
				toMain.setClass(LearnDialog.this, MainActivity.class);
				startActivity(toMain);
				LearnDialog.this.finish();
			}
			
		});
		
		
	}
	
	
}
