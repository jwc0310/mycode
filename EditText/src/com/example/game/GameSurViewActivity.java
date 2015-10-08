package com.example.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class GameSurViewActivity extends Activity{
	GameSurView mGameSur;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mGameSur = new GameSurView(this);
		setContentView(mGameSur);
	}
	
	public boolean onTouchEvent(MotionEvent event){
		return true;
	}
	
	public boolean onKeyDown(int keyCode,KeyEvent event){
		return true;
	}
	//按键弹起事件
		public boolean onKeyUp(int keyCode, KeyEvent event)
		{
			switch (keyCode)
			{
			//上方向键
			case KeyEvent.KEYCODE_DPAD_UP:
				mGameSur.y-=3;
				break;
			//下方向键
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mGameSur.y+=3;
				break;
			}
			return false;
		}
		
		public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event)
		{
			return true;
		}
}
