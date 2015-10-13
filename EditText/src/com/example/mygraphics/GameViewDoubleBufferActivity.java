package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

public class GameViewDoubleBufferActivity extends Activity {

	private GameViewDoubleBuffer mGvdb = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvdb = new GameViewDoubleBuffer(this);
		
		setContentView(mGvdb);
		
		
	}
	
}
