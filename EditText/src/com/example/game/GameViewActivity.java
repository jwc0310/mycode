package com.example.game;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class GameViewActivity extends Activity{
	
	private static final int REFRESH = 0x000001;
	private GameView mGameView = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		this.mGameView = new GameView(this);
		setContentView(mGameView);
		
		new Thread(new GameThread()).start();
	}
	
	Handler myHandler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case GameViewActivity.REFRESH:
				
				mGameView.invalidate();
				
				break;
			}
			
			super.handleMessage(msg);
			
		}
	};

	class GameThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(!Thread.currentThread().isInterrupted()){
				Message msg = new Message();
				msg.what = GameViewActivity.REFRESH;
				GameViewActivity.this.myHandler.sendMessage(msg);
				
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					Thread.currentThread().interrupt();
				}
			}
		}
		
		
		public boolean onTouchEvent(MotionEvent event){
			return true;
		}
		public boolean onKeyDown(int keyCode, KeyEvent event){
			return true;
		}
		
		public boolean onKeyUp(int keyCode, KeyEvent event){
			
			switch(keyCode){
			case KeyEvent.KEYCODE_DPAD_UP:
				mGameView.y -= 3;
				Log.i("Andy", "KEYCODE_DPAD_UP");
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mGameView.y += 3;
				Log.i("Andy", "KEYCODE_DPAD_DOWN");
				break;
				
			}
			
			return false;
		}
		
		public boolean onKeyDown(int keyCode,int repeatCount , KeyEvent event){
			return true;
		}
		
	}
	
}
