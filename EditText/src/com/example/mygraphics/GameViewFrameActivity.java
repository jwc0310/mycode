package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewFrameActivity extends Activity {
	
	private GameViewFrame mGvf = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvf = new GameViewFrame(this);
		
		setContentView(mGvf);
		
	}
}
