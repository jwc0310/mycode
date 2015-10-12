package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewRotateActivity extends Activity {
	
	private GameViewRotate mGvr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvr = new GameViewRotate(this);
		setContentView(mGvr);
		
		
		
	}
}
