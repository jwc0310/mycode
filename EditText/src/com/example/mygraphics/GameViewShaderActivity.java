package com.example.mygraphics;

import android.app.Activity;
import android.os.Bundle;

public class GameViewShaderActivity extends Activity {

	GameViewShader mGvs = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mGvs = new GameViewShader(this);
		setContentView(mGvs);
		
		
	}
	
}
