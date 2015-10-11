package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameFontActivity extends Activity {

	GameFont mGameFont = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		mGameFont = new GameFont(this);
		setContentView(mGameFont);
		
	}
	
}
