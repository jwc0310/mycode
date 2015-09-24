package com.example.edittext;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LearnImagebutton extends Activity{

	ImageView imageView;
	TextView tv;
	ImageButton ib1,ib2,ib3,ib4;
	
	
	
	int alpha = 255;
	
	Handler mHandler = new Handler();
	
	//widget thread
	boolean isrunning = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.imagebutton);
		
		
		
		isrunning = true;
		
		imageView = (ImageView)findViewById(R.id.imageView1);
		tv = (TextView)findViewById(R.id.textView2);
		ib1 = (ImageButton)findViewById(R.id.ib1);
		ib2 = (ImageButton)findViewById(R.id.ib2);
		ib3 = (ImageButton)findViewById(R.id.ib3);
		ib4 = (ImageButton)findViewById(R.id.ib4);
		
		ib1.setOnClickListener(ibEvent);
		ib4.setOnClickListener(ibEvent);
		ib3.setOnClickListener(ibEvent);
		ib2.setOnClickListener(ibEvent);
		
		imageView.setImageResource(R.drawable.ic);
		imageView.setAlpha(alpha);
		
		
		
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg){
				super.handleMessage(msg);
				imageView.setAlpha(alpha);
				tv.setText("Now alpha is "+Integer.toString(alpha));
				
				//update
				imageView.invalidate();
			}
		};
		
		
		
		
		Runnable run = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(isrunning){
					try{
						Thread.sleep(1000);
						updateAlpha();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
			
		};
		
		
		Thread thread = new Thread(run);
		thread.start();
		
		
		
	}
	
	public void updateAlpha(){
		if(alpha - 7 >=0){
			alpha -= 7;
		}else
		{
			alpha = 0;
			isrunning = false;
		}
		
		mHandler.sendMessage(mHandler.obtainMessage());
	}
	
	OnClickListener ibEvent = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.ib1:
				Dialog dialog = new AlertDialog.Builder(LearnImagebutton.this)
					.setTitle("TIPS")
					.setMessage("I am ImageButton one !")
					.setPositiveButton("确定",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					}).create();
				dialog.show();
				break;
			case R.id.ib2:
				Dialog dialog1 = new AlertDialog.Builder(LearnImagebutton.this)
					.setTitle("TIPS")
					.setMessage("I am ImageButton two ! I will use ImageButton3's icon")
					.setPositiveButton("确定",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							ib2.setImageDrawable(getResources().getDrawable(R.drawable.ic_vm_sound_on_dk));
						}
					}).create();
				dialog1.show();
				
				
				break;
			case R.id.ib3:
				Dialog dialog2 = new AlertDialog.Builder(LearnImagebutton.this)
				.setTitle("TIPS")
				.setMessage("I am ImageButton three ! I will use system dialer's icon")
				.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						ib3.setImageDrawable(getResources().getDrawable(R.drawable.ic_dialer_fork_current_call));
					}
				}).create();
				dialog2.show();
				
				
				
				break;
			case R.id.ib4:
				Dialog dialog3 = new AlertDialog.Builder(LearnImagebutton.this)
				.setTitle("TIPS")
				.setMessage("I am ImageButton four ! I am using system icon")
				.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
					}
				}).create();
				dialog3.show();
				
				
				break;
			}
		}
		
	};
	
	
	
	
	
}
