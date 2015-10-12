package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewScaleActivity extends Activity {
	
	private GameViewScale mGvs = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvs = new GameViewScale(this);
		
		setContentView(mGvs);
		
		
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
					
					mGvs.Scale +=1;
					
				}
			}
			
		}).start();
		
		
	}
	
}
