package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewGifActivity extends Activity{

	private GameViewGif mGvg = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvg = new GameViewGif(this);
		
		setContentView(mGvg);
	}
	
}
