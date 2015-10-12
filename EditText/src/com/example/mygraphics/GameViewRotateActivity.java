package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class GameViewRotateActivity extends Activity  {
	
	private GameViewRotate mGvr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvr = new GameViewRotate(this);
		setContentView(mGvr);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(!Thread.currentThread().isInterrupted()){
					try{
						Thread.sleep(3000);
					}catch(InterruptedException e){
						Thread.currentThread().interrupt();
					}
					mGvr.Angle+=45;
				}
				
			}
			
		}).start();
		
		
	}
}
