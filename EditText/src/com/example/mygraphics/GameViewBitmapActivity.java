package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class GameViewBitmapActivity extends Activity {

	
	private GameViewBitmap mGvb = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvb = new GameViewBitmap(this);
		
		setContentView(mGvb);
		
	}
	
}
