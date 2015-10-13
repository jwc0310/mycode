package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewTweenActivity extends Activity {

	private GameViewTween mGvt = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvt = new GameViewTween(this);
		
		setContentView(mGvt);
		
	}
	
}
