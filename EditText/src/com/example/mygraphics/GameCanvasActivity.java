package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameCanvasActivity extends Activity {

	private GameCanvas mGameCanvas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGameCanvas = new GameCanvas(this);
		
		setContentView(mGameCanvas);
	}
	
}
